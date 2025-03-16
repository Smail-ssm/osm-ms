package com.osm.oilproductionservice.domain.customTypes;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "waste_type")
@JsonTypeName("wastetype")
public class WasteType extends BaseType {

    public WasteType() {
        super();
    }

    public WasteType(String name, String description) {
        super(name, description); // 'id' is automatically handled by JPA
    }
}
