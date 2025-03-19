package com.osm.oilproductionservice.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.osm.oilproductionservice.domain.customTypes.OliveVarietyType}
 */
@Value
public class OliveVarietyTypeDto implements Serializable {
    Long id;
    String name;
    String description;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}