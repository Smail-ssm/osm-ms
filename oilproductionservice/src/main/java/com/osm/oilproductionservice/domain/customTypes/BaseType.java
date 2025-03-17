package com.osm.oilproductionservice.domain.customTypes;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, // Tells Jackson to use the class name as the type identifier
        include = JsonTypeInfo.As.PROPERTY, // This adds a property `type` in the JSON payload
        property = "type" // The property name for type information in the JSON payload
)
@JsonSubTypes({@JsonSubTypes.Type(value = WasteType.class, name = "wastetype"),
        @JsonSubTypes.Type(value = SupplierType.class, name = "suppliertype"),
        @JsonSubTypes.Type(value = OliveLotStatusType.class, name = "olivelotstatustype"),
        @JsonSubTypes.Type(value = Region.class, name = "region"),
        @JsonSubTypes.Type(value = OliveVarietyType.class, name = "olivevarietytype")})
public abstract class BaseType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // You can also use AUTO or UUID strategy depending on your DB
    private Long id;
    private String name; // The name of the type (e.g., WasteType, FarmerType)
    private String description; // Description of the type
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    /**
     * Constructs a new object.
     */
    public BaseType() {
        super();
    }

    public BaseType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public BaseType(String name, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
         this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    @Override
    public String toString() {
        return "BaseType{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + '}';
    }
}
