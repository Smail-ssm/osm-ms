//package com.osm.oilproductionservice.dto;
//
//import com.osm.oilproductionservice.enums.DeliveryType;
//import com.osm.oilproductionservice.model.UnifiedDelivery;
//import com.xdev.xdevbase.dtos.BaseDto;
//
//import java.time.LocalDateTime;
//
/// **
// * DTO for UnifiedDelivery.
// * Inherits common UnifiedDelivery fields and adds oil-specific data.
// */
//public class UnifiedDeliveryDTO extends BaseDto<UnifiedDelivery> {
//
//    private String deliveryNumber;
//    private DeliveryType deliveryType;
//    private String lotNumber;
//    private LocalDateTime deliveryDate;
//    private  BaseTypeDto region;
//    private TransporterDTO transporter;
//    private SupplierDto supplierType;
//
//
//    // Oil-specific fields
//    private String globalLotNumber;
//    private Float oilQuantity;
//    private BaseTypeDto oilVariety;
//    private Float unitPrice;
//    private Float price;
//    private Float paidAmount;
//    private Float unpaidAmount;
//    private StorageUnitDto storageUnit;
//    private  BaseTypeDto oilType;
//
//    public UnifiedDeliveryDTO() {
//    }
//
//    public String getDeliveryNumber() {
//        return deliveryNumber;
//    }
//
//    public void setDeliveryNumber(String deliveryNumber) {
//        this.deliveryNumber = deliveryNumber;
//    }
//
//    public DeliveryType getDeliveryType() {
//        return deliveryType;
//    }
//
//    public void setDeliveryType(DeliveryType deliveryType) {
//        this.deliveryType = deliveryType;
//    }
//
//    public String getLotNumber() {
//        return lotNumber;
//    }
//
//    public void setLotNumber(String lotNumber) {
//        this.lotNumber = lotNumber;
//    }
//
//    public LocalDateTime getDeliveryDate() {
//        return deliveryDate;
//    }
//
//    public void setDeliveryDate(LocalDateTime deliveryDate) {
//        this.deliveryDate = deliveryDate;
//    }
//
//    public BaseTypeDto getRegion() {
//        return region;
//    }
//
//    public void setRegion(BaseTypeDto region) {
//        this.region = region;
//    }
//
//    public TransporterDTO getTransporter() {
//        return transporter;
//    }
//
//    public void setTransporter(TransporterDTO transporter) {
//        this.transporter = transporter;
//    }
//
//    public SupplierDto getSupplierType() {
//        return supplierType;
//    }
//
//    public void setSupplierType(SupplierDto supplierType) {
//        this.supplierType = supplierType;
//    }
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
//    public BaseTypeDto getOilVariety() {
//        return oilVariety;
//    }
//
//    public void setOilVariety(BaseTypeDto oilVariety) {
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
//    public StorageUnitDto getStorageUnit() {
//        return storageUnit;
//    }
//
//    public void setStorageUnit(StorageUnitDto storageUnit) {
//        this.storageUnit = storageUnit;
//    }
//
//    public BaseTypeDto getOilType() {
//        return oilType;
//    }
//
//    public void setOilType(BaseTypeDto oilType) {
//        this.oilType = oilType;
//    }
//
//    public UnifiedDeliveryDTO(String deliveryNumber, DeliveryType deliveryType, String lotNumber, LocalDateTime deliveryDate, BaseTypeDto region, TransporterDTO transporter, SupplierDto supplierType, String globalLotNumber, Float oilQuantity, BaseTypeDto oilVariety, Float unitPrice, Float price, Float paidAmount, Float unpaidAmount, StorageUnitDto storageUnit, BaseTypeDto oilType) {
//        this.deliveryNumber = deliveryNumber;
//        this.deliveryType = deliveryType;
//        this.lotNumber = lotNumber;
//        this.deliveryDate = deliveryDate;
//        this.region = region;
//        this.transporter = transporter;
//        this.supplierType = supplierType;
//        this.globalLotNumber = globalLotNumber;
//        this.oilQuantity = oilQuantity;
//        this.oilVariety = oilVariety;
//        this.unitPrice = unitPrice;
//        this.price = price;
//        this.paidAmount = paidAmount;
//        this.unpaidAmount = unpaidAmount;
//        this.storageUnit = storageUnit;
//        this.oilType = oilType;
//    }
//}
