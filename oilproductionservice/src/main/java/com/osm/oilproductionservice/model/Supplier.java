package com.osm.oilproductionservice.model;

import com.xdev.xdevbase.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * A SupplierInfo.
 */
@Entity
@Table(name = "supplier")

public class Supplier extends BaseEntity {

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SupplierInfo supplierInfo;
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaseType genericSuppliertype;


    public Supplier(SupplierInfo supplierInfo, BaseType genericSuppliertype) {
        this.supplierInfo = supplierInfo;
        this.genericSuppliertype = genericSuppliertype;
    }

    public Supplier() {

    }

    public SupplierInfo getSupplier() {
        return supplierInfo;
    }

    public void setSupplier(SupplierInfo supplierInfo) {
        this.supplierInfo = supplierInfo;
    }

    public BaseType getGenericSuppliertype() {
        return genericSuppliertype;
    }

    public void setGenericSuppliertype(BaseType genericSuppliertype) {
        this.genericSuppliertype = genericSuppliertype;
    }
}
