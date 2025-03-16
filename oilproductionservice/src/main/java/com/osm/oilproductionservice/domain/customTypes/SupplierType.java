package com.osm.oilproductionservice.domain.customTypes;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "supplier_type")
@JsonTypeName("suppliertype")

public class SupplierType extends BaseType {

    public SupplierType() {
        super();
    }

    public SupplierType(String name, String description) {
        super(name, description); // 'id' is automatically handled by JPA
    }
}
