package com.osm.securityservice.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/security") // note the /security
public class AuthResource {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginVM vm) {
        return ResponseEntity.ok("some-jwt");
    }
}

// Example view model for incoming JSON
class LoginVM {
    private String username;
    private String password;
    // getters/setters
}
