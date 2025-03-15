package com.osm.securityservice.service;

import com.osm.securityservice.domain.ModuleName;
import com.osm.securityservice.domain.Permission;
import com.osm.securityservice.domain.Role;
import com.osm.securityservice.repository.PermissionRepository;
import com.osm.securityservice.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PermissionDataInitializer implements CommandLineRunner {

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override

    @Transactional
    public void run(String... args) throws Exception {
        // Create some dummy permissions and assign them to roles
        Permission createUser = new Permission();
        createUser.setModule(ModuleName.USER_MANAGEMENT);
        createUser.setAccessType("CREATE");
        createUser.setDescription("Permission to create a user");
        permissionRepository.save(createUser);

        Permission readUser = new Permission();
        readUser.setModule(ModuleName.USER_MANAGEMENT);
        readUser.setAccessType("READ");
        readUser.setDescription("Permission to read user information");
        permissionRepository.save(readUser);

        // Assign permissions to Superadmin role
        Role superAdminRole = roleRepository.findByName("SUPERADMIN");

        if (superAdminRole != null) {
            // Force loading the permissions collection (if using lazy loading)
            superAdminRole.getPermissions().size();  // This ensures the collection is initialized

            superAdminRole.getPermissions().add(createUser);
            superAdminRole.getPermissions().add(readUser);

            roleRepository.save(superAdminRole);  // Save the updated role
        }
    }

}
