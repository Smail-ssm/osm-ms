package com.osm.securityservice.userManagement.models.enums;

public enum OSMModule {
    HR(0), RECEPTION(1), PRODUCTION(2), FINANCE(3), USER(4);


    private final int value;

    OSMModule(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}

