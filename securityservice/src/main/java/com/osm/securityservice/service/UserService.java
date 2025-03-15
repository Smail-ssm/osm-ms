package com.osm.securityservice.service;

import com.osm.securityservice.domain.Role;
import com.osm.securityservice.domain.User;
import com.osm.securityservice.repository.RoleRepository;
import com.osm.securityservice.repository.UserRepository;
import com.osm.securityservice.service.dto.UserDTO;
import com.osm.securityservice.util.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Create a new user.
     * @param userDTO user data transfer object
     * @return the created user
     */
    public User createUser(UserDTO userDTO) {
        LOG.info("Attempting to create user: {}", userDTO.getUsername());

        // Check if role exists
        Role role = roleRepository.findByName("ADMIN");
        if (role == null) {
            role = new Role();
            role.setName("ADMIN");
            role.setDescription("ADMIN Role with all permissions.");
            role.setIsAdmin(true);
            roleRepository.save(role);
        }

        User user = new User();
        user.setUsername(userDTO.getUsername().toLowerCase());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        if (userDTO.getEmail() != null) {
            user.setEmail(userDTO.getEmail().toLowerCase());
        }

        String encryptedPassword = passwordEncoder.encode("userpassword"); // Default password can be changed later
        user.setPasswordHash(encryptedPassword);
        user.setResetDate(Instant.now());
        user.setActivated(false);
        user.setPhone(userDTO.getPhone());
        user.setIsActive(false);
        user.setRole(role); // Set the role for the user

        userRepository.save(user);
        LOG.debug("Created Information for User: {}", user);
        return user;
    }

    /**
     * Find a user by username or email.
     * @param usernameOrEmail username or email to search
     * @return the found user or null if not found
     */
    public User findByUsernameOrEmail(String usernameOrEmail) {
        LOG.info("Attempting to find user by username or email: {}", usernameOrEmail);
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
        if (user == null) {
            LOG.warn("No user found with username or email: {}", usernameOrEmail);
        } else {
            LOG.debug("User found: {}", user);
        }
        return user;
    }

    /**
     * Get all users.
     * @return a set of all users
     */
    public Set<User> getAllUsers() {
        LOG.info("Fetching all users.");
        Set<User> users = userRepository.findAll().stream().collect(Collectors.toSet());
        LOG.debug("Users fetched: {}", users);
        return users;
    }

    /**
     * Update an existing user's details.
     * @param userDTO the user details to update
     * @return the updated user
     */
    public User updateUser(Long userId, UserDTO userDTO) {
        LOG.info("Attempting to update user with ID: {}", userId);

        Optional<User> existingUserOptional = userRepository.findById(userId);
        if (!existingUserOptional.isPresent()) {
            LOG.error("User with ID {} not found. Update failed.", userId);
            throw new IllegalArgumentException("User with ID " + userId + " not found.");
        }

        User existingUser = existingUserOptional.get();
        existingUser.setUsername(userDTO.getUsername().toLowerCase());
        existingUser.setFirstName(userDTO.getFirstName());
        existingUser.setLastName(userDTO.getLastName());
        if (userDTO.getEmail() != null) {
            existingUser.setEmail(userDTO.getEmail().toLowerCase());
        }

        // Optionally update password (if provided)
        if (userDTO.getPassword() != null) {
            String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());
            existingUser.setPasswordHash(encryptedPassword);
            LOG.debug("Password updated for user: {}", existingUser.getUsername());
        }

        userRepository.save(existingUser);
        LOG.debug("Updated Information for User: {}", existingUser);
        return existingUser;
    }

    /**
     * Delete a user by username.
     * @param username the username of the user to delete
     */
    public void deleteUser(String username) {
        LOG.info("Attempting to delete user with username: {}", username);

        userRepository.findOneByUsername(username)
                .ifPresent(user -> {
                    userRepository.delete(user);
                    LOG.debug("Deleted User: {}", user);
                });
    }

    /**
     * Get a user by their ID.
     * @param userId the user ID to fetch
     * @return the found user or null if not found
     */
    public Optional<User> getUserById(Long userId) {
        LOG.info("Attempting to fetch user by ID: {}", userId);
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            LOG.debug("User found: {}", user.get());
        } else {
            LOG.warn("No user found with ID: {}", userId);
        }
        return user;
    }

    /**
     * Change a user's password.
     * @param userId the user ID
     * @param newPassword the new password
     * @return the updated user
     */
    public User changePassword(Long userId, String newPassword) {
        LOG.info("Attempting to change password for user with ID: {}", userId);

        Optional<User> existingUserOptional = userRepository.findById(userId);
        if (existingUserOptional.isEmpty()) {
            LOG.error("User with ID {} not found. Password change failed.", userId);
            throw new IllegalArgumentException("User with ID " + userId + " not found.");
        }

        User user = existingUserOptional.get();
        String encryptedPassword = passwordEncoder.encode(newPassword);
        user.setPasswordHash(encryptedPassword);
        userRepository.save(user);
        LOG.debug("Password changed for User: {}", user);
        return user;
    }

    /**
     * Generate a password reset token for the user.
     *
     * @param user the user for whom to generate the token.
     * @return the generated token.
     */
    public String generatePasswordResetToken(User user) {
        String token = TokenUtil.generateResetToken();
        user.setResetKey(token);  // Store the token in the user's record.
        user.setResetDate(Instant.now());  // Set the time when the token was generated.
        userRepository.save(user);
        return token;
    }
    /**
     * Complete the password reset process.
     *
     * @param newPassword the new password.
     * @param token the reset token.
     * @return the updated user, or empty if no user was found.
     */
    public Optional<User> completePasswordReset(String newPassword, String token) {
        Optional<User> user = userRepository.findOneByResetKey(token);
        if (user.isPresent() && user.get().getResetDate().isAfter(Instant.now().minus(1, ChronoUnit.HOURS))) {
            // Token is valid only for 1 hour.
            User resetUser = user.get();
            resetUser.setPasswordHash(passwordEncoder.encode(newPassword));
            resetUser.setResetKey(null); // Invalidate the token after use.
            resetUser.setResetDate(null);
            userRepository.save(resetUser);
            return Optional.of(resetUser);
        }
        return Optional.empty(); // Token expired or invalid
    }
}
