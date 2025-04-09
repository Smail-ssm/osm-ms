package com.osm.oilproductionservice.model;

import com.osm.oilproductionservice.enums.DeliveryType;
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

    @OneToMany(mappedBy = "delivery")
    public Set<QualityControlResult> qualityControlResults = new HashSet<>();
    private String receiptNumber;
    private String deliveryNumber;
    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;
    private String lotNumber;
    private LocalDateTime deliveryDate;
    private LocalDateTime trtDate;
    @Enumerated(EnumType.STRING)
    private OliveLotStatus status;
    private String globalLotNumber;
    private Float oliveQuantity;
    private Float oilQuantity;
    private Float rendement;
    @ManyToOne(fetch = FetchType.LAZY)
    private BaseType region;
    @ManyToOne(fetch = FetchType.LAZY)
    private Transporter transporter;
    @ManyToOne(fetch = FetchType.LAZY)
    private BaseType oliveVariety;
    @ManyToOne(fetch = FetchType.LAZY)
    private BaseType oilType;   // For "Biologique Conventionnelle"
    private Integer sackCount;  // or containerCount, if broader
    @ManyToOne(fetch = FetchType.LAZY)
    private BaseType oliveType;
    @ManyToOne(fetch = FetchType.LAZY)
    private StorageUnit storageUnit;
    @ManyToOne
    private SupplierType supplierType;
    @ManyToOne
    private MillMachine millMachine;
    // Pricing fields
    private Float unitPrice;     // Price per unit of olive oil
    private Float price;         // Total price for the delivery
    private Float paidAmount;    // Amount paid by the Supplier
    private Float unpaidAmount;  // Amount that remains unpaid
    // For "Tiers/Base"
    private String tierOrBase;
    private String parcel;
    // For "Biologique Conventionnelle"
    @ManyToOne(fetch = FetchType.LAZY)
    private BaseType oilVariety;
    @ManyToOne
    private BaseType productionMethod;
    public Delivery() {

    }

    public Delivery(Set<QualityControlResult> qualityControlResults, String receiptNumber, String deliveryNumber, DeliveryType deliveryType, String lotNumber, LocalDateTime deliveryDate, LocalDateTime trtDate, OliveLotStatus status, String globalLotNumber, Float oliveQuantity, Float oilQuantity, Float rendement, BaseType region, Transporter transporter, BaseType oliveVariety, BaseType oilType, Integer sackCount, BaseType oliveType, StorageUnit storageUnit, SupplierType supplierType, MillMachine millMachine, Float unitPrice, Float price, Float paidAmount, Float unpaidAmount, String tierOrBase, String parcel, BaseType oilVariety, BaseType productionMethod) {
        this.qualityControlResults = qualityControlResults;
        this.receiptNumber = receiptNumber;
        this.deliveryNumber = deliveryNumber;
        this.deliveryType = deliveryType;
        this.lotNumber = lotNumber;
        this.deliveryDate = deliveryDate;
        this.trtDate = trtDate;
        this.status = status;
        this.globalLotNumber = globalLotNumber;
        this.oliveQuantity = oliveQuantity;
        this.oilQuantity = oilQuantity;
        this.rendement = rendement;
        this.region = region;
        this.transporter = transporter;
        this.oliveVariety = oliveVariety;
        this.oilType = oilType;
        this.sackCount = sackCount;
        this.oliveType = oliveType;
        this.storageUnit = storageUnit;
        this.supplierType = supplierType;
        this.millMachine = millMachine;
        this.unitPrice = unitPrice;
        this.price = price;
        this.paidAmount = paidAmount;
        this.unpaidAmount = unpaidAmount;
        this.tierOrBase = tierOrBase;
        this.parcel = parcel;
        this.oilVariety = oilVariety;
        this.productionMethod = productionMethod;
    }

    public Integer getSackCount() {
        return sackCount;
    }

    public void setSackCount(Integer sackCount) {
        this.sackCount = sackCount;
    }

    public SupplierType getSupplierType() {
        return supplierType;
    }

    public void setSupplierType(SupplierType supplierType) {
        this.supplierType = supplierType;
    }

    public BaseType getProductionMethod() {
        return productionMethod;
    }

    public void setProductionMethod(BaseType productionMethod) {
        this.productionMethod = productionMethod;
    }

    public Set<QualityControlResult> getQualityControlResults() {
        return qualityControlResults;
    }

    public void setQualityControlResults(Set<QualityControlResult> qualityControlResults) {
        this.qualityControlResults = qualityControlResults;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(String deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
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

    public LocalDateTime getTrtDate() {
        return trtDate;
    }

    public void setTrtDate(LocalDateTime trtDate) {
        this.trtDate = trtDate;
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

    public Float getOilQuantity() {
        return oilQuantity;
    }

    public void setOilQuantity(Float oilQuantity) {
        this.oilQuantity = oilQuantity;
    }

    public Float getRendement() {
        return rendement;
    }

    public void setRendement(Float rendement) {
        this.rendement = rendement;
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

    public BaseType getOilType() {
        return oilType;
    }

    public void setOilType(BaseType oilType) {
        this.oilType = oilType;
    }

    public BaseType getOliveType() {
        return oliveType;
    }

    public void setOliveType(BaseType oliveType) {
        this.oliveType = oliveType;
    }

    public StorageUnit getStorageUnit() {
        return storageUnit;
    }

    public void setStorageUnit(StorageUnit storageUnit) {
        this.storageUnit = storageUnit;
    }

    public SupplierType getSupplier() {
        return supplierType;
    }

    public void setSupplier(SupplierType Supplier) {
        this.supplierType = Supplier;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
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
    }

    public Float getUnpaidAmount() {
        return unpaidAmount;
    }

    public void setUnpaidAmount(Float unpaidAmount) {
        this.unpaidAmount = unpaidAmount;
    }

    public String getTierOrBase() {
        return tierOrBase;
    }

    public void setTierOrBase(String tierOrBase) {
        this.tierOrBase = tierOrBase;
    }

    public String getParcel() {
        return parcel;
    }

    public void setParcel(String parcel) {
        this.parcel = parcel;
    }

    public BaseType getOilVariety() {
        return oilVariety;
    }

    public void setOilVariety(BaseType oilVariety) {
        this.oilVariety = oilVariety;
    }

    // Example: PostPersist logic for lot number
    @PostPersist
    public void assignLotNumber() {
        this.lotNumber = LotNumberGenerator.generateLotNumber(this);
    }

    public MillMachine getMillMachine() {
        return millMachine;
    }

    public void setMillMachine(MillMachine millMachine) {
        this.millMachine = millMachine;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }
}
