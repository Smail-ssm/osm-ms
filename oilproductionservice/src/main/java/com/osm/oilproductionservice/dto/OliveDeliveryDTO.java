//package com.osm.oilproductionservice.dto;
//
//import com.osm.oilproductionservice.enums.DeliveryType;
//import com.osm.oilproductionservice.enums.OliveLotStatus;
//import com.osm.oilproductionservice.model.UnifiedDelivery;
//import com.xdev.xdevbase.dtos.BaseDto;
//
//import java.time.LocalDateTime;
//
/// **
// * DTO for UnifiedDelivery.
// * Combines UnifiedDelivery fields with olive-specific properties.
// */
//public class UnifiedDeliveryDTO extends BaseDto<UnifiedDelivery> {
//
//    // Base fields
//    private String deliveryNumber;
//    private DeliveryType deliveryType;
//    private String lotNumber;
//    private LocalDateTime deliveryDate;
//    private BaseTypeDto region;
//    private TransporterDTO transporter;
//    private SupplierDto supplierType;
//
//    // Olive-specific fields
//    private LocalDateTime trtDate;
//    private Float rendement;
//    private MillMachineDto millMachine;
//    private Float oliveQuantity;
//    private BaseTypeDto oliveVariety;
//    private Integer sackCount;
//    private BaseTypeDto oliveType;
//    private String parcel;
//    private String globalLotNumber;
//    private OliveLotStatus status;
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
//    public LocalDateTime getTrtDate() {
//        return trtDate;
//    }
//
//    public void setTrtDate(LocalDateTime trtDate) {
//        this.trtDate = trtDate;
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
//    public MillMachineDto getMillMachine() {
//        return millMachine;
//    }
//
//    public void setMillMachine(MillMachineDto millMachine) {
//        this.millMachine = millMachine;
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
//    public BaseTypeDto getOliveVariety() {
//        return oliveVariety;
//    }
//
//    public void setOliveVariety(BaseTypeDto oliveVariety) {
//        this.oliveVariety = oliveVariety;
//    }
//
//    public Integer getSackCount() {
//        return sackCount;
//    }
//
//    public void setSackCount(Integer sackCount) {
//        this.sackCount = sackCount;
//    }
//
//    public BaseTypeDto getOliveType() {
//        return oliveType;
//    }
//
//    public void setOliveType(BaseTypeDto oliveType) {
//        this.oliveType = oliveType;
//    }
//
//    public String getParcel() {
//        return parcel;
//    }
//
//    public void setParcel(String parcel) {
//        this.parcel = parcel;
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
//    public OliveLotStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(OliveLotStatus status) {
//        this.status = status;
//    }
//
//    public UnifiedDeliveryDTO(String deliveryNumber, DeliveryType deliveryType, String lotNumber, LocalDateTime deliveryDate, BaseTypeDto region, TransporterDTO transporter, SupplierDto supplierType, LocalDateTime trtDate, Float rendement, MillMachineDto millMachine, Float oliveQuantity, BaseTypeDto oliveVariety, Integer sackCount, BaseTypeDto oliveType, String parcel, String globalLotNumber, OliveLotStatus status) {
//        this.deliveryNumber = deliveryNumber;
//        this.deliveryType = deliveryType;
//        this.lotNumber = lotNumber;
//        this.deliveryDate = deliveryDate;
//        this.region = region;
//        this.transporter = transporter;
//        this.supplierType = supplierType;
//        this.trtDate = trtDate;
//        this.rendement = rendement;
//        this.millMachine = millMachine;
//        this.oliveQuantity = oliveQuantity;
//        this.oliveVariety = oliveVariety;
//        this.sackCount = sackCount;
//        this.oliveType = oliveType;
//        this.parcel = parcel;
//        this.globalLotNumber = globalLotNumber;
//        this.status = status;
//    }
//
//    public UnifiedDeliveryDTO() {
//    }
//
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
//}
