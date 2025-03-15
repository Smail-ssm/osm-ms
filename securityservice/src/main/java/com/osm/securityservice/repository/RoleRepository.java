package com.osm.securityservice.repository;

import com.osm.securityservice.domain.Role;
import com.osm.securityservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleByName(String name);
    Role findByName(String name);

}
