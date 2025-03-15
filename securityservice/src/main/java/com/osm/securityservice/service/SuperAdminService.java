package com.osm.securityservice.service;

import com.osm.securityservice.domain.User;
import com.osm.securityservice.domain.Role;
import com.osm.securityservice.repository.UserRepository;
import com.osm.securityservice.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SuperAdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void createSuperAdmin() {
        // Check if the superadmin already exists
        if (!userRepository.existsByUsername("superadmin")) {
            System.out.println("Superadmin doesn't exist. Creating now...");

            // Create role if it doesn't exist
            Role superAdminRole = roleRepository.findRoleByName("SUPERADMIN");
            if (superAdminRole == null) {
                System.out.println("SUPERADMIN role not found. Creating the role...");
                superAdminRole = new Role();
                superAdminRole.setName("SUPERADMIN");
                superAdminRole.setDescription("Superadmin Role with all permissions.");
                superAdminRole.setIsAdmin(true);
                roleRepository.save(superAdminRole);
            }

            // Check if user already exists with the same email
            if (userRepository.existsByEmail("superadmin@osm.com")) {
                System.out.println("Superadmin with this email already exists.");
                return; // Exit the method if the user already exists
            }

            // Create superadmin user
            User superAdmin = new User();
            superAdmin.setUsername("superadmin");
            superAdmin.setEmail("superadmin@osm.com");
            superAdmin.setPhone("1234567890");
            superAdmin.setPasswordHash(passwordEncoder.encode("superadminpassword")); // Use a strong password
            superAdmin.setIsActive(true);
            superAdmin.setRole(superAdminRole);

            // Save the superadmin user
            userRepository.save(superAdmin);
            System.out.println("Superadmin user created successfully!");
        } else {
            System.out.println("Superadmin already exists.");
        }
    }
    @PostConstruct
    public void createAdmin() {
        // Check if the admin already exists
        if (!userRepository.existsByUsername("admin")) {
            System.out.println("admin doesn't exist. Creating now...");

            // Create role if it doesn't exist
            Role  AdminRole = roleRepository.findRoleByName("ADMIN");
            if (AdminRole == null) {
                System.out.println("SUPERADMIN role not found. Creating the role...");
                AdminRole = new Role();
                AdminRole.setName("ADMIN");
                AdminRole.setDescription("ADMIN Role with all permissions.");
                AdminRole.setIsAdmin(true);
                roleRepository.save(AdminRole);
            }
            // Create superadmin user
//            User superAdmin = new User();
//            superAdmin.setUsername("superadmin");
//            superAdmin.setEmail("superadmin@osm.com");
//            superAdmin.setPhone("1234567890");
//            superAdmin.setPasswordHash(passwordEncoder.encode("superadminpassword")); // Use a strong password
//            superAdmin.setIsActive(true);
//            superAdmin.setRole(AdminRole);
//
//            // Save the superadmin user
//            userRepository.save(superAdmin);
            System.out.println("admin user created successfully!");
        } else {
            System.out.println("Superadmin already exists.");
        }
    }
}
