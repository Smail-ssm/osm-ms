package com.osm.oilproductionservice.dto;


import com.osm.oilproductionservice.enums.DeliveryType;
import com.osm.oilproductionservice.enums.OliveLotStatus;
import com.osm.oilproductionservice.model.BaseType;
import com.osm.oilproductionservice.model.Delivery;
import com.osm.oilproductionservice.model.SupplierType;
import com.osm.oilproductionservice.model.Transporter;
import com.xdev.xdevbase.dtos.BaseDto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class DeliveryDto extends BaseDto<Delivery> {


    public Set<QualityControlResultDto> qualityControlResults = new HashSet<>();

    private String receiptNumber;
    private String lotNumber;
    private LocalDateTime deliveryDate;
    private LocalDateTime trtDate;

    private OliveLotStatus status;

    // Existing field (kept as is)
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
    private BaseTypeDto oilVariety;   // For "Biologique Conventionnelle"
    private BaseTypeDto productionMethod;   // For "Biologique Conventionnelle"

    private String tierOrBase;      // For "Tiers/Base"
    private String parcel;          // For "Parcelle"
    private MillMachineDto millMachine;
    private Integer sackCount;
    private Transporter transporter;
    private BaseType oilType;
    private BaseType oliveType;
    private SupplierType supplierType;
    private DeliveryType deliveryType;

    public DeliveryDto() {
    }


    public Set<QualityControlResultDto> getQualityControlResults() {
        return qualityControlResults;
    }

    public void setQualityControlResults(Set<QualityControlResultDto> qualityControlResults) {
        this.qualityControlResults = qualityControlResults;
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

    public BaseTypeDto getOilVariety() {
        return oilVariety;
    }

    public void setOilVariety(BaseTypeDto oilVariety) {
        this.oilVariety = oilVariety;
    }

    public BaseTypeDto getProductionMethod() {
        return productionMethod;
    }

    public void setProductionMethod(BaseTypeDto productionMethod) {
        this.productionMethod = productionMethod;
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

    public MillMachineDto getMillMachine() {
        return millMachine;
    }

    public void setMillMachine(MillMachineDto millMachine) {
        this.millMachine = millMachine;
    }

    public Integer getSackCount() {
        return sackCount;
    }

    public void setSackCount(Integer sackCount) {
        this.sackCount = sackCount;
    }

    public Transporter getTransporter() {
        return transporter;
    }

    public void setTransporter(Transporter transporter) {
        this.transporter = transporter;
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

    public SupplierType getSupplierType() {
        return supplierType;
    }

    public void setSupplierType(SupplierType supplierType) {
        this.supplierType = supplierType;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }
}