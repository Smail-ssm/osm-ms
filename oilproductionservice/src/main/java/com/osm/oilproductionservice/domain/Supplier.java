package com.osm.oilproductionservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.osm.oilproductionservice.domain.customTypes.Region;
import com.osm.oilproductionservice.domain.customTypes.SupplierType;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.HashSet;
import java.util.Set;

/**
 * A Supplier.
 */
@Entity
@Table(name = "supplier")

  public class Supplier  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "phone")
    private String phone;
    @Nullable
    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    // Many-to-one relationship with Region (a Supplier is linked to one Region)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")  // This creates a foreign key column in the supplier table
    @JsonIgnoreProperties(value = {"suppliers"})
    private Region region;

    // One-to-many relationship with Delivery (Supplier has many deliveries)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = {"oliveLots", "paymentStatus", "transactionType", "region", "variety", "storageUnit", "supplier"}, allowSetters = true)
    private Set<Delivery> deliveries = new HashSet<>();

    // Many-to-one relationship with SupplierType (Supplier has one type)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "suppliertype_id")
    private SupplierType suppliertype;

    // Calculated fields (no persistence, calculated at runtime)
    @Transient
    private Float totalOliveQuantity;

    @Transient
    private Float totalOilQuantity;

    @Transient
    private Float totalPaidAmount;

    @Transient
    private Float totalUnpaidAmount;

    @Transient
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

    // Getters and setters for the rest of the fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Set<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(Set<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public SupplierType getSuppliertype() {
        return suppliertype;
    }

    public void setSuppliertype(SupplierType suppliertype) {
        this.suppliertype = suppliertype;
    }
}
