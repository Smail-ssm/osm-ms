package com.osm.oilproductionservice.dto;

import com.osm.oilproductionservice.model.OilDelivery;
import com.xdev.xdevbase.dtos.BaseDto;

import java.time.LocalDateTime;

public class OilDeliveryDTO extends BaseDto<OilDelivery> {

    private String receiptNumber;
    private String deliveryNumber;
    private String lotNumber;
    private LocalDateTime deliveryDate;
    private String globalLotNumber;
    private Float oilQuantity;

    // Pricing details
    private Float unitPrice;
    private Float price;
    private Float paidAmount;
    private Float unpaidAmount;

    private SupplierDto supplier;
    private StorageUnitDto storageUnit;
    private BaseTypeDto region;
    private BaseTypeDto oilType;

    public OilDeliveryDTO() {
    }

    public OilDeliveryDTO(String receiptNumber, String deliveryNumber, String lotNumber, LocalDateTime deliveryDate, String globalLotNumber, Float oilQuantity, Float unitPrice, Float price, Float paidAmount, Float unpaidAmount, SupplierDto supplier, StorageUnitDto storageUnit, BaseTypeDto region, BaseTypeDto oilType) {
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
        this.supplier = supplier;
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

    public SupplierDto getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierDto supplier) {
        this.supplier = supplier;
    }

    public StorageUnitDto getStorageUnit() {
        return storageUnit;
    }

    public void setStorageUnit(StorageUnitDto storageUnit) {
        this.storageUnit = storageUnit;
    }

    public BaseTypeDto getRegion() {
        return region;
    }

    public void setRegion(BaseTypeDto region) {
        this.region = region;
    }

    public BaseTypeDto getOilType() {
        return oilType;
    }

    public void setOilType(BaseTypeDto oilType) {
        this.oilType = oilType;
    }
}
