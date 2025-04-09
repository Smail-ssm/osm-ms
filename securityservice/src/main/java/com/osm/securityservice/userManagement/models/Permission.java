package com.osm.securityservice.userManagement.models;

import com.osm.securityservice.userManagement.models.enums.OSMModule;
import com.xdev.xdevbase.entities.BaseEntity;
import jakarta.persistence.Entity;
import org.hibernate.envers.Audited;

@Entity
@Audited
public class Permission extends BaseEntity {
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
