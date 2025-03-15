package com.osm.securityservice.repository;

import com.osm.securityservice.domain.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, String> {}
