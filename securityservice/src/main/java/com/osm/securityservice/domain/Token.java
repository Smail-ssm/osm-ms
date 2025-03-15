package com.osm.securityservice.domain;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.Instant;

@Entity
@EnableJpaAuditing
public class Token {

    @Id
    // Because tokenValue is required unique, we can use it as the primary key
    private String tokenValue;

    @Column(nullable = false)
    private Instant issuedAt;

    @Column(nullable = false)
    private Instant expiresAt;

    private String scopes; // e.g., "ROLE_ADMIN,ROLE_USER"

    // Relationship: Many Tokens to One User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Boolean revoked = false;

    // constructors, getters, setters
}
