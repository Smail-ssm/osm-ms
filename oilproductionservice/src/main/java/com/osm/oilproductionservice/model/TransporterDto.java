package com.osm.oilproductionservice.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * DTO for {@link Transporter}
 */
public record TransporterDto(UUID id, Boolean isDeleted, String createdBy, OffsetDateTime createdDate,
                             String lastModifiedBy, OffsetDateTime lastModifiedDate, String name, String contactNumber,
                             String email, String licenseNumber, String address) implements Serializable {
}