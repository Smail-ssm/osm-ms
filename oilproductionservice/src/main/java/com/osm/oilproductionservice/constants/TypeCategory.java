package com.osm.oilproductionservice.constants;


public enum TypeCategory {
    WASTETYPE(1), REGION(2), SUPPLIERTYPE(3), OLIVEVARIETY(4), OLIVETYPE(5);
    private final int value;

    TypeCategory(int value) {
        this.value = value;
    }

    // Helper method to find the enum by its value
    public static TypeCategory fromValue(int value) {
        for (TypeCategory category : values()) {
            if (category.getValue() == (value)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Unknown type: " + value);
    }

    public int getValue() {
        return value;
    }
}