package com.osm.oilproductionservice.model.customTypes;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "variety")
@JsonTypeName("variety")
public class OliveVariety extends BaseType {

    public OliveVariety() {
        super();
    }

    public OliveVariety(String name, String description) {
        super(name, description);
    }
}
