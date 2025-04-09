package com.osm.oilproductionservice.model;

import com.osm.oilproductionservice.constants.TypeCategory;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * DTO for {@link BaseType}
 */
public record BaseTypeDto(UUID id, Boolean isDeleted, String createdBy, OffsetDateTime createdDate,
                          String lastModifiedBy, OffsetDateTime lastModifiedDate, String name, String description,
                          TypeCategory type) implements Serializable {
}