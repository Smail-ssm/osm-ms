package com.osm.securityservice.service;

import com.osm.securityservice.domain.Permission;
import com.osm.securityservice.domain.Role;
import com.osm.securityservice.domain.ModuleName;
import com.osm.securityservice.repository.PermissionRepository;
import com.osm.securityservice.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private RoleRepository roleRepository;

    public void createPermissionsAndAssignToRoles() {
        // Creating permissions for USER_MANAGEMENT module
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
        Role superAdminRole = roleRepository.findRoleByName("SUPERADMIN");

        if (superAdminRole != null) {
            superAdminRole.getPermissions().add(createUser);
            superAdminRole.getPermissions().add(readUser);
            // Add more permissions as needed

            roleRepository.save(superAdminRole);
        }
    }
}
