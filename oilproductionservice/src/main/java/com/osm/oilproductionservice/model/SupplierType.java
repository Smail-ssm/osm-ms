package com.osm.oilproductionservice.model;

import com.xdev.xdevbase.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * A Supplier.
 */
@Entity
@Table(name = "supplier_type")

public class SupplierType extends BaseEntity {

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Supplier supplier;
    // Many-to-one relationship with SupplierType (Supplier has one type)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaseType genericSuppliertype;


    public SupplierType(Supplier supplier, BaseType genericSuppliertype) {
        this.supplier = supplier;
        this.genericSuppliertype = genericSuppliertype;
    }

    public SupplierType() {

    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public BaseType getGenericSuppliertype() {
        return genericSuppliertype;
    }

    public void setGenericSuppliertype(BaseType genericSuppliertype) {
        this.genericSuppliertype = genericSuppliertype;
    }
}
