package com.osm.oilproductionservice.constants;


public enum TypeCategory {
    WASTETYPE("wastetype"),
    REGION("region"),
    SUPPLIERTYPE("suppliertype"),
    OLIVEVARIETY("oliveVariety"),
    OLIVELOTSTATUSTYPE("olivelotstatustype"),
    OLIVEVARIETYTYPE("olivevarietytype");

    private final String value;

    TypeCategory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    // Helper method to find the enum by its value
    public static TypeCategory fromValue(String value) {
        for (TypeCategory category : values()) {
            if (category.getValue().equalsIgnoreCase(value)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Unknown type: " + value);
    }
}