package com.osm.oilproductionservice.model.customTypes;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "waste_type")
@JsonTypeName("wastetype")
public class WasteType extends BaseType {


}
