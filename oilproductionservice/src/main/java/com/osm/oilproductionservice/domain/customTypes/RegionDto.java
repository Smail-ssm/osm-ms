package com.osm.oilproductionservice.domain.customTypes;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Region}
 */
@Value
public class RegionDto implements Serializable {
    Long id;
    String name;
    String description;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}