package com.osm.oilproductionservice.dto.out;


import com.osm.oilproductionservice.enums.OliveLotStatus;
import com.osm.oilproductionservice.model.Delivery;
import com.xdev.xdevbase.dtos.BaseDto;

import java.time.LocalDateTime;

public class DeliveryDto extends BaseDto<Delivery> {


    private String receiptNumber;
    private String lotNumber;
    private LocalDateTime deliveryDate;
    private LocalDateTime triturationDate;
    private OliveLotStatus status;
    private StorageUnitDto storageUnit;
    private String globalLotNumber;
    private Float oliveQuantity;
    private Float oilQuantity;
    private String deliveryNumber;
    private Float rendement;
     private Float unitPrice;
    private Float price;
    private Float paidAmount;
    private Float unpaidAmount;

    private BaseTypeDto region;
    private BaseTypeDto oliveVariety;
    private BaseTypeDto oliveType;
    private SupplierDto supplier;

    public DeliveryDto() {
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

    public LocalDateTime getTriturationDate() {
        return triturationDate;
    }

    public void setTriturationDate(LocalDateTime triturationDate) {
        this.triturationDate = triturationDate;
    }

    public OliveLotStatus getStatus() {
        return status;
    }

    public void setStatus(OliveLotStatus status) {
        this.status = status;
    }

    public StorageUnitDto getStorageUnit() {
        return storageUnit;
    }

    public void setStorageUnit(StorageUnitDto storageUnit) {
        this.storageUnit = storageUnit;
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

    public String getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(String deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }

    public Float getRendement() {
        return rendement;
    }

    public void setRendement(Float rendement) {
        this.rendement = rendement;
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

    public BaseTypeDto getRegion() {
        return region;
    }

    public void setRegion(BaseTypeDto region) {
        this.region = region;
    }

    public BaseTypeDto getOliveVariety() {
        return oliveVariety;
    }

    public void setOliveVariety(BaseTypeDto oliveVariety) {
        this.oliveVariety = oliveVariety;
    }

    public BaseTypeDto getOliveType() {
        return oliveType;
    }

    public void setOliveType(BaseTypeDto oliveType) {
        this.oliveType = oliveType;
    }

    public SupplierDto getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierDto supplier) {
        this.supplier = supplier;
    }

    public DeliveryDto(String receiptNumber, String lotNumber, LocalDateTime deliveryDate, LocalDateTime triturationDate, OliveLotStatus status, StorageUnitDto storageUnit, String globalLotNumber, Float oliveQuantity, Float oilQuantity, String deliveryNumber, Float rendement, Float unitPrice, Float price, Float paidAmount, Float unpaidAmount, BaseTypeDto region, BaseTypeDto oliveVariety, BaseTypeDto oliveType, SupplierDto supplier) {
        this.receiptNumber = receiptNumber;
        this.lotNumber = lotNumber;
        this.deliveryDate = deliveryDate;
        this.triturationDate = triturationDate;
        this.status = status;
        this.storageUnit = storageUnit;
        this.globalLotNumber = globalLotNumber;
        this.oliveQuantity = oliveQuantity;
        this.oilQuantity = oilQuantity;
        this.deliveryNumber = deliveryNumber;
        this.rendement = rendement;
        this.unitPrice = unitPrice;
        this.price = price;
        this.paidAmount = paidAmount;
        this.unpaidAmount = unpaidAmount;
        this.region = region;
        this.oliveVariety = oliveVariety;
        this.oliveType = oliveType;
        this.supplier = supplier;
    }
}