package com.osm.securityservice.repository;

import com.osm.securityservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameOrEmail(String username, String email);
    Optional<User> findOneByUsername(String login);

    boolean existsByUsername(String superadmin);
    boolean existsByEmail(String superadmin);

    Optional<User> findOneByResetKey(String token);
}
