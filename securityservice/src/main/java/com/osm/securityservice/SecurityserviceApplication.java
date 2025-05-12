package com.osm.securityservice;

import com.osm.securityservice.userManagement.data.PermissionRepository;
import com.osm.securityservice.userManagement.dtos.OUTDTO.OSMUserDTO;
import com.osm.securityservice.userManagement.dtos.OUTDTO.PermissionDTO;
import com.osm.securityservice.userManagement.dtos.OUTDTO.RoleDTO;
import com.osm.securityservice.userManagement.models.enums.OSMModule;
import com.osm.securityservice.userManagement.service.PermissionService;
import com.osm.securityservice.userManagement.service.RoleService;
import com.osm.securityservice.userManagement.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
@ComponentScan(basePackages = {"com.xdev", "com.xdev.xdevbase", "com.osm.securityservice"})
@EnableJpaRepositories(basePackages = {"com.xdev", "com.xdev.xdevbase", "com.osm.securityservice"}, repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class SecurityserviceApplication {
    private final UserService userService;
    private final RoleService roleService;
    private final PermissionService permissionService;
    private final PasswordEncoder passwordEncoder;

    public SecurityserviceApplication(UserService userService, RoleService roleService, PermissionRepository permissionRepository, PermissionService permissionService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.permissionService = permissionService;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
		SpringApplication.run(SecurityserviceApplication.class, args);
	}

    @Bean
    public CommandLineRunner initAdminUser() {
        return args -> {
            // Check if admin user already exists
            if (userService.getByUsername("admin") != null) {
                return;
            }

            // Create permissions
            PermissionDTO readUsers = new PermissionDTO();
            readUsers.setPermissionName("READ_USER");
            readUsers.setModule(OSMModule.USER); // Enum or Entity
            PermissionDTO read = permissionService.save(readUsers);

            PermissionDTO writeUsers = new PermissionDTO();
            writeUsers.setPermissionName("WRITE_USER");
            writeUsers.setModule(OSMModule.USER);
            PermissionDTO write = permissionService.save(writeUsers);


            RoleDTO adminRole = new RoleDTO();
            adminRole.setRoleName("ADMIN");
            adminRole.setPermissions(Set.of(read, write));
            RoleDTO saveRole = roleService.save(adminRole);


            // Create admin user
            OSMUserDTO admin = new OSMUserDTO();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setEmail("admin@example.com");
            admin.setPhoneNumber("1234567890");
            admin.setRole(saveRole);
            admin.setLocked(false); // not locked
            userService.save(admin);
        };
    }

}
