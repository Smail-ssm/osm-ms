package com.osm.oilproductionservice.enums;

/**
 * The OliveLotStatus enumeration.
 */


public enum OliveLotStatus {

    NEW("Newly received olive lot, awaiting processing"),
    IN_PROGRESS("Currently being processed"),
    COMPLETED("Processing completed, ready for further actions"),
    REFUSED("Refused based on Quality control"),
    CANCELLED("Cancelled, no further actions");

    private final String description;

    // Constructor for the enum
    OliveLotStatus(String description) {
        this.description = description;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

}