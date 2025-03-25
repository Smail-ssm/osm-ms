package com.osm.oilproductionservice.model;

import com.osm.oilproductionservice.enums.OliveLotStatus;
import com.osm.oilproductionservice.util.LotNumberGenerator;
import com.xdev.xdevbase.entities.BaseEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * A Delivery.
 */
@Entity
@Table(name = "delivery")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Delivery extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy = "delivery")
    public Set<QualityControlResult> qualityControlResults = new HashSet<>();
    private String receiptNumber;
    private String deliveryNumber;
    private String lotNumber;
    private LocalDateTime deliveryDate;
    @Enumerated(EnumType.STRING)
    private OliveLotStatus status;
    private String globalLotNumber;
    private Float oliveQuantity;
    private Float oilQuantity;
    private Float rendement;
    @ManyToOne(fetch = FetchType.LAZY)
    private BaseType region;
    @ManyToOne(fetch = FetchType.LAZY)
    private BaseType oliveVariety;
    @ManyToOne(fetch = FetchType.LAZY)
    private BaseType oliveType;
    private String storageUnit;
    @ManyToOne(optional = false)
    private Supplier supplier;
    // New Attributes
    private Float unitPrice;      // Price per unit of olive oil
    private Float price;          // Total price for the delivery
    private Float paidAmount;     // Amount paid by the supplier
    private Float unpaidAmount;   // Amount that remains unpaid


    public String getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(String deliveryNumber) {
        this.deliveryNumber = deliveryNumber;

    }

    public Float getOilQuantity() {
        return oilQuantity;
    }

    public void setOilQuantity(Float oilQuantity) {
        this.oilQuantity = oilQuantity;
    }

    public Set<QualityControlResult> getQualityControlResults() {
        return qualityControlResults;
    }

    public void setQualityControlResults(Set<QualityControlResult> qualityControlResults) {
        this.qualityControlResults.clear();
        if (qualityControlResults != null) {
            this.qualityControlResults.addAll(qualityControlResults);
        }
    }

    // Constructor, getters, setters, etc.

    // Calculate price based on olive quantity and unit price
    public void calculatePrice() {
        if (oliveQuantity != null && unitPrice != null) {
            this.price = oliveQuantity * unitPrice;
        } else {
            this.price = 0f;
        }
    }

    // Method to calculate the unpaid amount based on price and paid amount
    public void calculateUnpaidAmount() {
        if (this.price != null && this.paidAmount != null) {
            this.unpaidAmount = this.price - this.paidAmount;
        } else {
            this.unpaidAmount = this.price;
        }
    }

    public Float getRendement() {
        // Ensure oilQuantity is not null and not zero to avoid division by zero
        if (this.oilQuantity != null && this.oilQuantity != 0) {
            // Calculate rendement as a percentage
            this.rendement = (this.oliveQuantity / this.oilQuantity) * 100;
        } else {
            // If oilQuantity is null or zero, set rendement to 0
            this.rendement = (float) 0;
        }
        // Return the calculated rendement as a percentage
        return this.rendement;
    }

    public void setRendement(Float rendement) {
        this.rendement = rendement;
    }

    public float calculateRendement() {
        // Ensure oilQuantity is not null and not zero to avoid division by zero
        if (this.oilQuantity != null && this.oilQuantity != 0) {
            // Calculate rendement as a percentage
            this.rendement = (this.oliveQuantity / this.oilQuantity) * 100;
        } else {
            // If oilQuantity is null or zero, set rendement to 0
            this.rendement = (float) 0;
        }
        // Return the calculated rendement as a percentage
        return this.rendement;
    }

    public BaseType getOliveType() {
        return oliveType;
    }

    public void setOliveType(BaseType oliveType) {
        this.oliveType = oliveType;
    }

    // Method to update paid amount
    public void makePayment(Float amount) {
        if (amount != null && amount > 0) {
            this.paidAmount += amount;
            calculateUnpaidAmount();  // Recalculate unpaid amount
        }
    }

    // Method to check if the delivery is fully paid
    public boolean isFullyPaid() {
        return this.unpaidAmount <= 0;
    }

    // Getters and Setters for the new attributes
    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
        calculatePrice();  // Recalculate price when unit price changes
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Float paidAmount) {
        this.paidAmount = paidAmount;
        calculateUnpaidAmount();  // Recalculate unpaid amount
    }

    public Float getUnpaidAmount() {
        return unpaidAmount;
    }

    public void setUnpaidAmount(Float unpaidAmount) {
        this.unpaidAmount = unpaidAmount;
    }

    // Getters and Setters for existing attributes
    public Supplier getSupplier() {
        return this.supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }


    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public OliveLotStatus getStatus() {
        return status;
    }

    public void setStatus(OliveLotStatus status) {
        this.status = status;
    }

    public String getGlobalLotNumber() {
        return globalLotNumber;
    }

    public void setGlobalLotNumber(String globalLotNumber) {
        this.globalLotNumber = globalLotNumber;
    }

    public Float getOliveQuantity() {
        return oliveQuantity;
    }

    public void setOliveQuantity(Float oliveQuantity) {
        this.oliveQuantity = oliveQuantity;
        calculatePrice();  // Recalculate price when quantity changes
    }

    public BaseType getRegion() {
        return region;
    }

    public void setRegion(BaseType region) {
        this.region = region;
    }

    public BaseType getOliveVariety() {
        return oliveVariety;
    }

    public void setOliveVariety(BaseType oliveVariety) {
        this.oliveVariety = oliveVariety;
    }


    @PostPersist
    public void assignLotNumber() {
        // Use the LotNumberGenerator to generate the lot number now that the id is set.
        this.lotNumber = LotNumberGenerator.generateLotNumber(this);

        // Optionally, if your JPA provider doesn't automatically flush changes made in @PostPersist,
        // you might need to call an update or merge operation here to persist the new lot number.
    }
}
