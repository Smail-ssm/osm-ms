package com.osm.oilproductionservice.dto.genericDTO;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDateTime;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, // Use the "type" property to identify subtypes
        include = JsonTypeInfo.As.PROPERTY, // Include the type as a property in JSON
        property = "type" // The name of the property that holds the type information
)
@JsonSubTypes(
        {
        @JsonSubTypes.Type(value = OliveVarietyDto.class, name = "oliveVariety"),
        @JsonSubTypes.Type(value = RegionDto.class, name = "region"),
        @JsonSubTypes.Type(value = SupplierTypeDto.class, name = "suppliertype"),
        @JsonSubTypes.Type(value = WasteTypeDto.class, name = "wasteType")})
public abstract class BaseTypeDto {
    private Long id; // Unique identifier for the type
    private String name; // The name of the type (e.g., "Plastic Waste", "Local Supplier")
    private String description; // Description of the type
    private LocalDateTime createdAt; // Timestamp when the type was created
    private LocalDateTime updatedAt; // Timestamp when the type was last updated
    private String type;

    public BaseTypeDto() {
    }

    public BaseTypeDto(Long id, String name, String description, LocalDateTime createdAt, LocalDateTime updatedAt, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}