package com.osm.oilproductionservice.domain;

import com.osm.oilproductionservice.domain.customTypes.BaseType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "region")
public class Region extends BaseType {

    public Region() {
        super();
    }

    public Region(String name, String description) {
        super(name, description); // 'id' is automatically handled by JPA
    }
}
