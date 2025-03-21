package com.osm.oilproductionservice.model.customTypes;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,             // Use the subtype name for serialization/deserialization
        include = JsonTypeInfo.As.PROPERTY,     // Embed it as a property in the JSON object
        property = "type"                       // Name of the property that holds the subtype identifier
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = WasteType.class,      name = "wastetype"),
        @JsonSubTypes.Type(value = SupplierType.class,   name = "suppliertype"),  // CHANGED HERE
        @JsonSubTypes.Type(value = Region.class,         name = "region"),
        @JsonSubTypes.Type(value = OliveVariety.class,   name = "oliveVariety")
})
public abstract class BaseType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;  // This field is used to store the JSON discriminator itself
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public BaseType() {
        super();
    }

    public BaseType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public BaseType(Long id, String name, String type, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and setters...

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

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "BaseType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
