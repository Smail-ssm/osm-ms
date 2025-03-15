package com.osm.securityservice.domain;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@EnableJpaAuditing
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ModuleName module;

    @Column(nullable = false)
    private String accessType; // e.g. "READ_ONLY", "CRUD"

    private String description;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

    // Mapped side of Many-to-Many
    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles = new HashSet<>();

    // constructors, getters, setters
}
