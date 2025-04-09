package com.osm.securityservice.userManagement.dtos.OUTDTO;

import com.osm.securityservice.userManagement.models.Role;
import com.xdev.xdevbase.dtos.BaseDto;

import java.util.Set;

public class RoleDTO extends BaseDto<Role> {
    private String roleName;
    private Set<PermissionDTO> permissions;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<PermissionDTO> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<PermissionDTO> permissions) {
        this.permissions = permissions;
    }
}
