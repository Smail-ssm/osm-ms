package com.osm.oilproductionservice.domain.customTypes;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "olive_variety_type")
@JsonTypeName("olivevarietytype")
public class OliveVarietyType extends BaseType {

    public OliveVarietyType() {
        super();
    }

    public OliveVarietyType(String name, String description) {
        super(name, description); // 'id' is automatically handled by JPA
    }
}
