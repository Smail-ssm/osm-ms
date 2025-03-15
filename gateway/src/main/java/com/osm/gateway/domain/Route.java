package com.osm.gateway.domain;

import jakarta.persistence.*;

@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String path;

    @Column(nullable = false)
    private String serviceEndpoint;

    @Column(nullable = false)
    private String methods; // e.g. "GET,POST,PUT"

    // constructors, getters, setters
}
