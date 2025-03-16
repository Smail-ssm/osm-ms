package com.osm.oilproductionservice.domain;


import com.osm.oilproductionservice.domain.customTypes.OliveVarietyType;
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
    @ManyToOne(fetch = FetchType.LAZY)
    private Region region;

    @ManyToOne(fetch = FetchType.LAZY)
    private OliveVarietyType variety;

    private String storageUnit;

    @ManyToOne(optional = false)
    private Supplier supplier;

    public Supplier getSupplier() {
        return this.supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    // One-to-One relationship with QualityControl entity
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quality_control_id", nullable = true)  // Nullable set to true, making it optional
    private QualityControl qualityControl;  // Link to quality control record

    // Getter and setter for qualityControl
    public QualityControl getQualityControl() {
        return qualityControl;
    }

    public void setQualityControl(QualityControl qualityControl) {
        this.qualityControl = qualityControl;
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
}
