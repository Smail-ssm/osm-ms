//package com.osm.oilproductionservice.dto.in;
//
//import com.osm.oilproductionservice.dto.out.StorageUnitDto;
//import com.osm.oilproductionservice.enums.OliveLotStatus;
//import com.osm.oilproductionservice.model.Delivery;
//import com.xdev.xdevbase.dtos.BaseDto;
//
//import java.time.LocalDateTime;
//import java.util.UUID;
//
//
//public class DeliveryDtoIn extends BaseDto<Delivery> {
//
//
//    private String receiptNumber;
//    private String lotNumber;
//    private LocalDateTime deliveryDate;
//    private LocalDateTime triturationDate;
//    private OliveLotStatus status;
//    private StorageUnitDto storageUnit;
//    private String globalLotNumber;
//    private Float oliveQuantity;
//    private Float oilQuantity;
//    private String deliveryNumber;
//    private Float rendement;
//    private Float unitPrice;
//    private Float price;
//    private Float paidAmount;
//    private Float unpaidAmount;
//
//
//
//    private UUID regionId;
//    private UUID oliveVarietyId;
//    private UUID oliveTypeId;
//    private UUID supplierId;
//    public DeliveryDtoIn() {
//    }
//
//    public String getReceiptNumber() {
//        return receiptNumber;
//    }
//
//    public void setReceiptNumber(String receiptNumber) {
//        this.receiptNumber = receiptNumber;
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
//    public LocalDateTime getTriturationDate() {
//        return triturationDate;
//    }
//
//    public void setTriturationDate(LocalDateTime triturationDate) {
//        this.triturationDate = triturationDate;
//    }
//
//    public OliveLotStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(OliveLotStatus status) {
//        this.status = status;
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
//    public String getGlobalLotNumber() {
//        return globalLotNumber;
//    }
//
//    public void setGlobalLotNumber(String globalLotNumber) {
//        this.globalLotNumber = globalLotNumber;
//    }
//
//    public Float getOliveQuantity() {
//        return oliveQuantity;
//    }
//
//    public void setOliveQuantity(Float oliveQuantity) {
//        this.oliveQuantity = oliveQuantity;
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
//    public String getDeliveryNumber() {
//        return deliveryNumber;
//    }
//
//    public void setDeliveryNumber(String deliveryNumber) {
//        this.deliveryNumber = deliveryNumber;
//    }
//
//    public Float getRendement() {
//        return rendement;
//    }
//
//    public void setRendement(Float rendement) {
//        this.rendement = rendement;
//    }
//
//    public UUID getRegion() {
//        return regionId;
//    }
//
//    public void setRegion(UUID region) {
//        this.regionId = region;
//    }
//
//
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
//    public UUID getSupplier() {
//        return supplierId;
//    }
//
//    public void setSupplier(UUID supplier) {
//        this.supplierId = supplier;
//    }
//
//    public UUID getRegionId() {
//        return regionId;
//    }
//
//    public void setRegionId(UUID regionId) {
//        this.regionId = regionId;
//    }
//
//    public UUID getOliveVarietyId() {
//        return oliveVarietyId;
//    }
//
//    public void setOliveVarietyId(UUID oliveVarietyId) {
//        this.oliveVarietyId = oliveVarietyId;
//    }
//
//    public UUID getOliveTypeId() {
//        return oliveTypeId;
//    }
//
//    public void setOliveTypeId(UUID oliveTypeId) {
//        this.oliveTypeId = oliveTypeId;
//    }
//
//    public UUID getSupplierId() {
//        return supplierId;
//    }
//
//    public void setSupplierId(UUID supplierId) {
//        this.supplierId = supplierId;
//    }
//
//    public DeliveryDtoIn(String receiptNumber, String lotNumber, LocalDateTime deliveryDate,
//                         LocalDateTime triturationDate, OliveLotStatus status,
//                         StorageUnitDto storageUnit, String globalLotNumber,
//                         Float oliveQuantity, Float oilQuantity, String deliveryNumber,
//                         Float rendement, Float unitPrice, Float price, Float paidAmount,
//                         Float unpaidAmount, UUID regionId, UUID oliveVarietyId, UUID oliveTypeId, UUID supplierId) {
//        this.receiptNumber = receiptNumber;
//        this.lotNumber = lotNumber;
//        this.deliveryDate = deliveryDate;
//        this.triturationDate = triturationDate;
//        this.status = status;
//        this.storageUnit = storageUnit;
//        this.globalLotNumber = globalLotNumber;
//        this.oliveQuantity = oliveQuantity;
//        this.oilQuantity = oilQuantity;
//        this.deliveryNumber = deliveryNumber;
//        this.rendement = rendement;
//        this.unitPrice = unitPrice;
//        this.price = price;
//        this.paidAmount = paidAmount;
//        this.unpaidAmount = unpaidAmount;
//        this.regionId = regionId;
//        this.oliveVarietyId = oliveVarietyId;
//        this.oliveTypeId = oliveTypeId;
//        this.supplierId = supplierId;
//    }
//}