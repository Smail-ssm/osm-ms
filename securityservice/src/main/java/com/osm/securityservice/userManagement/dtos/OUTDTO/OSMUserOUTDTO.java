package com.osm.securityservice.userManagement.dtos.OUTDTO;

import com.osm.securityservice.userManagement.models.OSMUser;
import com.osm.securityservice.userManagement.models.enums.ConfirmationMethod;
import com.xdev.xdevbase.dtos.BaseDto;

public class OSMUserOUTDTO extends BaseDto<OSMUser> {
    private String username;
    private String email;
    private String phoneNumber;
    private boolean isLocked;
    private ConfirmationMethod confirmationMethod;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public ConfirmationMethod getConfirmationMethod() {
        return confirmationMethod;
    }

    public void setConfirmationMethod(ConfirmationMethod confirmationMethod) {
        this.confirmationMethod = confirmationMethod;
    }
}
