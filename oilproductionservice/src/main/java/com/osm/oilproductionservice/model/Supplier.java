package com.osm.oilproductionservice.model;

import com.xdev.xdevbase.entities.BaseEntity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * A Supplier.
 */
@Entity
@Table(name = "supplier")

public class Supplier extends BaseEntity {


    private String name;

    private String lastname;

    private String phone;
    private String email;

    private String address;


    // One-to-many relationship with Delivery (Supplier has many deliveries)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Delivery> deliveries = new HashSet<>();

    // Many-to-one relationship with SupplierType (Supplier has one type)
    @ManyToOne(fetch = FetchType.LAZY)
    private BaseType suppliertype;

    // Calculated fields (no persistence, calculated at runtime)
    private Float totalOliveQuantity;

    private Float totalOilQuantity;

    private Float totalPaidAmount;

    private Float totalUnpaidAmount;

    private Float totalDebt;

    // Methods to calculate totals based on deliveries

    public Float getTotalOliveQuantity() {
        totalOliveQuantity = 0f;
        for (Delivery delivery : deliveries) {
            totalOliveQuantity += delivery.getOliveQuantity();
        }
        return totalOliveQuantity;
    }

    public Float getTotalOilQuantity() {
        totalOilQuantity = 0f;
        for (Delivery delivery : deliveries) {
            totalOilQuantity += delivery.getOilQuantity();
        }
        return totalOilQuantity;
    }

    public Float getTotalPaidAmount() {
        totalPaidAmount = 0f;
        for (Delivery delivery : deliveries) {
            if (delivery.getPaidAmount() != null) {
                totalPaidAmount += delivery.getPaidAmount();
            }
        }
        return totalPaidAmount;
    }

    public Float getTotalUnpaidAmount() {
        totalUnpaidAmount = 0f;
        for (Delivery delivery : deliveries) {
            if (delivery.getUnpaidAmount() != null) {
                totalUnpaidAmount += delivery.getUnpaidAmount();
            }
        }
        return totalUnpaidAmount;
    }

    public Float getTotalDebt() {
        totalDebt = getTotalUnpaidAmount() - getTotalPaidAmount();
        return totalDebt;
    }

    public Supplier() {
    }

    public Supplier(String name, String lastname, String phone, String email, String address, Set<Delivery> deliveries, BaseType suppliertype, Float totalOliveQuantity, Float totalOilQuantity, Float totalPaidAmount, Float totalUnpaidAmount, Float totalDebt) {
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.deliveries = deliveries;
        this.suppliertype = suppliertype;
        this.totalOliveQuantity = totalOliveQuantity;
        this.totalOilQuantity = totalOilQuantity;
        this.totalPaidAmount = totalPaidAmount;
        this.totalUnpaidAmount = totalUnpaidAmount;
        this.totalDebt = totalDebt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(Set<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public BaseType getSuppliertype() {
        return suppliertype;
    }

    public void setSuppliertype(BaseType suppliertype) {
        this.suppliertype = suppliertype;
    }

    public void setTotalOliveQuantity(Float totalOliveQuantity) {
        this.totalOliveQuantity = totalOliveQuantity;
    }

    public void setTotalOilQuantity(Float totalOilQuantity) {
        this.totalOilQuantity = totalOilQuantity;
    }

    public void setTotalPaidAmount(Float totalPaidAmount) {
        this.totalPaidAmount = totalPaidAmount;
    }

    public void setTotalUnpaidAmount(Float totalUnpaidAmount) {
        this.totalUnpaidAmount = totalUnpaidAmount;
    }

    public void setTotalDebt(Float totalDebt) {
        this.totalDebt = totalDebt;
    }
}
