package com.osm.oilproductionservice.model.customTypes;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "region")
@JsonTypeName("region")
public class Region extends BaseType {

}
