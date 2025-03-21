package com.osm.oilproductionservice.model.customTypes;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "supplier_type")
@JsonTypeName("suppliertype")

public class SupplierType extends BaseType {

}
