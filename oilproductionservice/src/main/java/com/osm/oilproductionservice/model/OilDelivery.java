package com.osm.oilproductionservice.model;

import com.xdev.xdevbase.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "oil_delivery")
public class OilDelivery extends BaseEntity implements Serializable {
    private String receiptNumber;
    private String deliveryNumber;
    private String lotNumber;
    private LocalDateTime deliveryDate;


    private String globalLotNumber;
    private Float oilQuantity;    // Volume of oil delivered

    // Pricing details
    private Float unitPrice;      // Price per unit of oil
    private Float price;          // Total price for the delivery
    private Float paidAmount;     // Amount already paid
    private Float unpaidAmount;   // Remaining unpaid amount

    // Associations
    @ManyToOne(optional = false)
    private Supplier Supplier;

    @ManyToOne(fetch = FetchType.LAZY)
    private StorageUnit storageUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    private BaseType region;

    @ManyToOne(fetch = FetchType.LAZY)
    private BaseType oilType;     // Classification (e.g., Extra Virgin, Virgin, etc.)

    public OilDelivery() {
    }

    public OilDelivery(String receiptNumber, String deliveryNumber, String lotNumber, LocalDateTime deliveryDate, String globalLotNumber, Float oilQuantity, Float unitPrice, Float price, Float paidAmount, Float unpaidAmount, Supplier Supplier, StorageUnit storageUnit, BaseType region, BaseType oilType) {
        this.receiptNumber = receiptNumber;
        this.deliveryNumber = deliveryNumber;
        this.lotNumber = lotNumber;
        this.deliveryDate = deliveryDate;
        this.globalLotNumber = globalLotNumber;
        this.oilQuantity = oilQuantity;
        this.unitPrice = unitPrice;
        this.price = price;
        this.paidAmount = paidAmount;
        this.unpaidAmount = unpaidAmount;
        this.Supplier = Supplier;
        this.storageUnit = storageUnit;
        this.region = region;
        this.oilType = oilType;
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

    public String getGlobalLotNumber() {
        return globalLotNumber;
    }

    public void setGlobalLotNumber(String globalLotNumber) {
        this.globalLotNumber = globalLotNumber;
    }

    public Float getOilQuantity() {
        return oilQuantity;
    }

    public void setOilQuantity(Float oilQuantity) {
        this.oilQuantity = oilQuantity;
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

    public Supplier getSupplier() {
        return Supplier;
    }

    public void setSupplier(Supplier Supplier) {
        this.Supplier = Supplier;
    }

    public StorageUnit getStorageUnit() {
        return storageUnit;
    }

    public void setStorageUnit(StorageUnit storageUnit) {
        this.storageUnit = storageUnit;
    }

    public BaseType getRegion() {
        return region;
    }

    public void setRegion(BaseType region) {
        this.region = region;
    }

    public BaseType getOilType() {
        return oilType;
    }

    public void setOilType(BaseType oilType) {
        this.oilType = oilType;
    }
}
