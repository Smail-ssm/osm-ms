//package com.osm.oilproductionservice.model;
//
//import com.osm.oilproductionservice.enums.DeliveryType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//
//import java.io.Serializable;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "oil_delivery")
//public class UnifiedDelivery extends UnifiedDelivery implements Serializable {
//
//    // Oil-specific fields (UnifiedDelivery already has deliveryNumber, lotNumber, deliveryDate, etc.)
//    @ManyToOne(fetch = FetchType.LAZY)
//    private BaseType oilVariety;
//    @ManyToOne(fetch = FetchType.LAZY)
//    private StorageUnit storageUnit;
//    @ManyToOne(fetch = FetchType.LAZY)
//    private BaseType oilType;     // Classification (e.g., Extra Virgin, Virgin, etc.)
//
//    public String getGlobalLotNumber() {
//        return globalLotNumber;
//    }
//
//    public void setGlobalLotNumber(String globalLotNumber) {
//        this.globalLotNumber = globalLotNumber;
//    }
//
//    public Float getOilQuantity() {
//        return oilQuantity;
//    }
//
//    public void setOilQuantity(Float oilQuantity) {
//        this.oilQuantity = oilQuantity;
//    }
//
//    public BaseType getOilVariety() {
//        return oilVariety;
//    }
//
//    public void setOilVariety(BaseType oilVariety) {
//        this.oilVariety = oilVariety;
//    }
//
//    public Float getUnitPrice() {
//        return unitPrice;
//    }
//
//    public void setUnitPrice(Float unitPrice) {
//        this.unitPrice = unitPrice;
//    }
//
//    public Float getPrice() {
//        return price;
//    }
//
//    public void setPrice(Float price) {
//        this.price = price;
//    }
//
//    public Float getPaidAmount() {
//        return paidAmount;
//    }
//
//    public void setPaidAmount(Float paidAmount) {
//        this.paidAmount = paidAmount;
//    }
//
//    public Float getUnpaidAmount() {
//        return unpaidAmount;
//    }
//
//    public void setUnpaidAmount(Float unpaidAmount) {
//        this.unpaidAmount = unpaidAmount;
//    }
//
//    public StorageUnit getStorageUnit() {
//        return storageUnit;
//    }
//
//    public void setStorageUnit(StorageUnit storageUnit) {
//        this.storageUnit = storageUnit;
//    }
//
//    public BaseType getOilType() {
//        return oilType;
//    }
//
//    public void setOilType(BaseType oilType) {
//        this.oilType = oilType;
//    }
//}
