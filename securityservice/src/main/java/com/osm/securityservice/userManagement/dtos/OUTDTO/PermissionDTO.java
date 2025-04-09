package com.osm.securityservice.userManagement.dtos.OUTDTO;

import com.osm.securityservice.userManagement.models.Permission;
import com.osm.securityservice.userManagement.models.enums.OSMModule;
import com.xdev.xdevbase.dtos.BaseDto;


public class PermissionDTO extends BaseDto<Permission> {
    private String permissionName;
    private OSMModule module;

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public OSMModule getModule() {
        return module;
    }

    public void setModule(OSMModule module) {
        this.module = module;
    }

}
