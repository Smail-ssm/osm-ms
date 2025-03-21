package com.osm.oilproductionservice.dto;


import java.time.LocalDateTime;


 public class OliveLotStatusTypeDto extends BaseTypeDto {
    public OliveLotStatusTypeDto() {
    }

    public OliveLotStatusTypeDto(Long id, String name, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(id, name, description, createdAt, updatedAt);
    }
    // Add any additional fields specific to OliveLotStatusType here (if needed)
}