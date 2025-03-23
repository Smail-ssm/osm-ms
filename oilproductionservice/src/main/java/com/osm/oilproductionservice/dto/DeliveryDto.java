package com.osm.oilproductionservice.dto;


import com.osm.oilproductionservice.enums.OliveLotStatus;
import com.osm.oilproductionservice.model.Delivery;
import com.xdev.xdevbase.dtos.BaseDto;

import java.time.LocalDateTime;
import java.util.Set;

public class DeliveryDto extends BaseDto<Delivery> {


    private String receiptNumber;
    private String lotNumber;
    private LocalDateTime deliveryDate;
    private OliveLotStatus status;
    private String globalLotNumber;
    private Float oliveQuantity;
    private Float oilQuantity;
    private Float rendement;
    private String supplierName;
    private String regionName;
    private String oliveVarietyName;
    private String oliveTypeName;
    private Float unitPrice;
    private Float price;
    private Float paidAmount;
    private Float unpaidAmount;

    public DeliveryDto() {
    }

    public DeliveryDto(String receiptNumber, String lotNumber, LocalDateTime deliveryDate, OliveLotStatus status, String globalLotNumber, Float oliveQuantity, Float oilQuantity, Float rendement, String supplierName, String regionName, String oliveVarietyName, String oliveTypeName, Float unitPrice, Float price, Float paidAmount, Float unpaidAmount) {
        this.receiptNumber = receiptNumber;
        this.lotNumber = lotNumber;
        this.deliveryDate = deliveryDate;
        this.status = status;
        this.globalLotNumber = globalLotNumber;
        this.oliveQuantity = oliveQuantity;
        this.oilQuantity = oilQuantity;
        this.rendement = rendement;
        this.supplierName = supplierName;
        this.regionName = regionName;
        this.oliveVarietyName = oliveVarietyName;
        this.oliveTypeName = oliveTypeName;
        this.unitPrice = unitPrice;
        this.price = price;
        this.paidAmount = paidAmount;
        this.unpaidAmount = unpaidAmount;
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

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getOliveVarietyName() {
        return oliveVarietyName;
    }

    public void setOliveVarietyName(String oliveVarietyName) {
        this.oliveVarietyName = oliveVarietyName;
    }

    public String getOliveTypeName() {
        return oliveTypeName;
    }

    public void setOliveTypeName(String oliveTypeName) {
        this.oliveTypeName = oliveTypeName;
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

    // Constructors, getters, setters
}