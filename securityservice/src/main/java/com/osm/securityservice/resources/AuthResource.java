package com.osm.securityservice.resources;

import com.osm.securityservice.domain.Permission;
import com.osm.securityservice.domain.Role;
import com.osm.securityservice.domain.User;
import com.osm.securityservice.service.UserService;
import com.osm.securityservice.service.dto.ManagedUserVM;
import com.osm.securityservice.service.dto.PasswordChangeDTO;
import com.osm.securityservice.service.dto.UserDTO;
import com.osm.securityservice.util.MailService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.micrometer.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/security")
public class AuthResource {

    private static final Logger LOG = LoggerFactory.getLogger(AuthResource.class);

    private final UserService userService;
    private final MailService mailerService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthResource(UserService userService, MailService mailerService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.mailerService = mailerService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Helper method to validate password length
     */
    private static boolean isPasswordLengthInvalid(String password) {
        return StringUtils.isEmpty(password) || password.length() < ManagedUserVM.PASSWORD_MIN_LENGTH || password.length() > ManagedUserVM.PASSWORD_MAX_LENGTH;
    }

    /**
     * Handle user login
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userLoginDTO) {
        LOG.info("Attempting to login user: {}", userLoginDTO.getUsername());

        // Check if the user exists by username or email
        User user = userService.findByUsernameOrEmail(userLoginDTO.getUsername());
        if (user == null) {
            LOG.warn("Login failed: User not found for {}", userLoginDTO.getUsername());
            return ResponseEntity.badRequest().body("User not found");
        }

        // Check if the password is correct
        boolean passwordMatches = passwordEncoder.matches(userLoginDTO.getPassword(), user.getPasswordHash());
        if (!passwordMatches) {
            LOG.warn("Login failed: Incorrect password for {}", userLoginDTO.getUsername());
            return ResponseEntity.badRequest().body("Incorrect password");
        }

        // Extract roles from the user
        Role roles = user.getRole();

        // Extract permissions from the user's roles. This assumes that your User entity has a getRoles() method
        // and that each Role has a getPermissions() method returning a collection of Permission.
        List<String> permissions = user.getRole().getPermissions().stream().map(Permission::getAccessType)  // or another method to get a unique permission identifier
                .distinct()                      // ensure no duplicates
                .collect(Collectors.toList());

        // Build JWT claims including roles and permissions
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", roles);
        claims.put("permissions", permissions);
        byte[] keyBytes = new byte[32];  // 32 bytes = 256 bits
        new SecureRandom().nextBytes(keyBytes);
        SecretKey secretKey = new javax.crypto.spec.SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());

        // Set token validity (for example, 1 day)
        long expirationTimeInMs = 86400000L;
        Date issuedAt = new Date();
        Date expiration = new Date(issuedAt.getTime() + expirationTimeInMs);

        // IMPORTANT: Use a secure key. In production, store this key securely (e.g., in environment variables or configuration).

        // Build the JWT token
        String token = Jwts.builder().setClaims(claims).setSubject(user.getUsername()).setIssuedAt(issuedAt).setExpiration(expiration).signWith(SignatureAlgorithm.HS256, secretKey).compact();

        LOG.info("Login successful for user: {}", userLoginDTO.getUsername());
        return ResponseEntity.ok(new JwtResponse(token));
    }

    /**
     * Handle user signup and email token generation
     */
    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody UserDTO userDTO) {
        LOG.info("Attempting to sign up user: {}", userDTO.getEmail());

        // Create the user
        User newUser = userService.createUser(userDTO);

        // Generate password reset token
        String token = userService.generatePasswordResetToken(newUser);

        // Send password setup email
        try {
            mailerService.sendPasswordSetupEmail(newUser, token);
            LOG.info("Password setup email sent to user: {}", userDTO.getEmail());
        } catch (MailException e) {
            LOG.error("Error sending password setup email to user: {}", userDTO.getEmail(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser); // Return created user
    }

    /**
     * Set new password using the reset token
     */
    @PostMapping("/set-password")
    public ResponseEntity<?> setPassword(@RequestParam("token") String token, @RequestBody PasswordChangeDTO passwordChangeDTO) {
        LOG.info("Attempting to set password using token: {}", token);

        if (isPasswordLengthInvalid(passwordChangeDTO.getNewPassword())) {
            LOG.warn("Password length invalid for user with token: {}", token);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Password must meet length requirements");
        }

        // Complete password reset process
        Optional<User> user = userService.completePasswordReset(passwordChangeDTO.getNewPassword(), token);

        if (user.isEmpty()) {
            LOG.warn("Password reset failed: Invalid token or user not found for token {}", token);
            return ResponseEntity.badRequest().body("No user found for this reset token");
        }

        // Successfully reset password
        LOG.info("Password reset successful for user: {}", user.get().getEmail());
        return ResponseEntity.ok("Password has been reset successfully");
    }

    public class JwtResponse {
        private String token;

        public JwtResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
