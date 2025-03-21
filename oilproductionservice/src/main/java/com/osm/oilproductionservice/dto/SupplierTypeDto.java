package com.osm.oilproductionservice.dto;

import java.io.Serializable;
import java.time.LocalDateTime;


 public class SupplierTypeDto extends  BaseTypeDto implements Serializable {
    public SupplierTypeDto() {
    }

    public SupplierTypeDto(Long id, String name, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(id, name, description, createdAt, updatedAt);
    }
    // Add any additional fields specific to SupplierType here (if needed)
}