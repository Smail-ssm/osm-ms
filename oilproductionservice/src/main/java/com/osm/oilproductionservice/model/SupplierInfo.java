package com.osm.oilproductionservice.model;

import com.xdev.xdevbase.entities.BaseEntity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * A SupplierInfo.
 */
@Entity
@Table(name = "supplier_info")
public class SupplierInfo extends BaseEntity {

    private String name;
    private String lastname;
    private String phone;
    private String email;
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    private BaseType region;
    // One-to-many relationship with UnifiedDelivery (SupplierInfo has many deliveries)
    @OneToMany(fetch = FetchType.LAZY)
    private Set<UnifiedDelivery> deliveries = new HashSet<>();
//    // Associations to child deliveries
//    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY)
//    private Set<UnifiedDelivery> oliveDeliveries = new HashSet<>();
//
//    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY)
//    private Set<UnifiedDelivery> oilDeliveries = new HashSet<>();

    // Calculated fields (not persisted)
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

    public SupplierInfo() {
    }

    // Standard getters and setters for basic fields

    // Calculated totals based on child class values

    /**
     * Sums the olive quantity from all olive deliveries.
     */
    public Float getTotalOliveQuantity() {
        totalOliveQuantity = 0f;
        for (UnifiedDelivery delivery : deliveries) {
            totalOliveQuantity += delivery.getOliveQuantity();
        }
        return totalOliveQuantity;
    }

    public void setTotalOliveQuantity(Float totalOliveQuantity) {
        this.totalOliveQuantity = totalOliveQuantity;
    }

    /**
     * Sums the oil quantity from all oil deliveries.
     */
    public Float getTotalOilQuantity() {
        totalOilQuantity = 0f;
        for (UnifiedDelivery delivery : deliveries) {
            totalOilQuantity += delivery.getOilQuantity();
        }
        return totalOilQuantity;
    }

    public void setTotalOilQuantity(Float totalOilQuantity) {
        this.totalOilQuantity = totalOilQuantity;
    }

    /**
     * Sums the paid amounts from all oil deliveries.
     * (Assuming olive deliveries do not carry financial fields.)
     */
    public Float getTotalPaidAmount() {
        totalPaidAmount = 0f;
        for (UnifiedDelivery delivery : deliveries) {
            if (delivery.getPaidAmount() != null) {
                totalPaidAmount += delivery.getPaidAmount();
            }
        }
        return totalPaidAmount;
    }

    public void setTotalPaidAmount(Float totalPaidAmount) {
        this.totalPaidAmount = totalPaidAmount;
    }

    /**
     * Sums the unpaid amounts from all oil deliveries.
     */
    public Float getTotalUnpaidAmount() {
        totalUnpaidAmount = 0f;
        for (UnifiedDelivery delivery : deliveries) {
            if (delivery.getUnpaidAmount() != null) {
                totalUnpaidAmount += delivery.getUnpaidAmount();
            }
        }
        return totalUnpaidAmount;
    }

    public void setTotalUnpaidAmount(Float totalUnpaidAmount) {
        this.totalUnpaidAmount = totalUnpaidAmount;
    }

    /**
     * Calculates total debt (for example, as the difference between unpaid and paid amounts).
     */
    public Float getTotalDebt() {
        totalDebt = getTotalUnpaidAmount() - getTotalPaidAmount();
        return totalDebt;
    }

    public void setTotalDebt(Float totalDebt) {
        this.totalDebt = totalDebt;
    }
}
