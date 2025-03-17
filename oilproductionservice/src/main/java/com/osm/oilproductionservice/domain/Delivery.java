package com.osm.oilproductionservice.domain;

import com.osm.oilproductionservice.domain.customTypes.OliveVarietyType;
import com.osm.oilproductionservice.domain.customTypes.Region;
import com.osm.oilproductionservice.enums.OliveLotStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Delivery.
 */
@Entity
@Table(name = "delivery")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Delivery implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "receipt_number", nullable = false)
    private String receiptNumber;

    @Column(name = "lot_number", nullable = false)
    private String lotNumber;

    @Column(name = "delivery_date", nullable = false)
    private Instant deliveryDate;

    @Enumerated(EnumType.STRING)  // Use EnumType.STRING to persist the enum as a string
    @Column(name = "status")
    private OliveLotStatus status;  // Enum field to store the status of the olive lot

    @Column(name = "global_ot_number")
    private String globalLotNumber;

    @Column(name = "olive_quantity")
    private Float oliveQuantity;

    public Float getOilQuantity() {
        return oilQuantity;
    }

    public void setOilQuantity(Float oilQuantity) {
        this.oilQuantity = oilQuantity;
    }

    @Column(name = "oil_quantity")
    private Float oilQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    private Region region;

    @ManyToOne(fetch = FetchType.LAZY)
    private OliveVarietyType variety;

    private String storageUnit;

    @ManyToOne(optional = false)
    private Supplier supplier;

    // One-to-One relationship with QualityControl entity
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quality_control_id", nullable = true)  // Nullable set to true, making it optional
    private QualityControl qualityControl;  // Link to quality control record

    // New Attributes
    @Column(name = "unit_price")
    private Float unitPrice;      // Price per unit of olive oil
    @Column(name = "price")
    private Float price;          // Total price for the delivery
    @Column(name = "paid_amount")
    private Float paidAmount;     // Amount paid by the supplier
    @Column(name = "unpaid_amount")
    private Float unpaidAmount;   // Amount that remains unpaid

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Instant getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Instant deliveryDate) {
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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public OliveVarietyType getVariety() {
        return variety;
    }

    public void setVariety(OliveVarietyType variety) {
        this.variety = variety;
    }

    public String getStorageUnit() {
        return storageUnit;
    }

    public void setStorageUnit(String storageUnit) {
        this.storageUnit = storageUnit;
    }

    public QualityControl getQualityControl() {
        return qualityControl;
    }

    public void setQualityControl(QualityControl qualityControl) {
        this.qualityControl = qualityControl;
    }
}
