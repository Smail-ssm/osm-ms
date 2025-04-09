package com.osm.securityservice.userManagement.models;

import com.xdev.xdevbase.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import org.hibernate.envers.Audited;

import java.util.HashSet;
import java.util.Set;


@Entity
@Audited
public class Role extends BaseEntity {
    private String roleName;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Permission> permissions = new HashSet<Permission>();

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
