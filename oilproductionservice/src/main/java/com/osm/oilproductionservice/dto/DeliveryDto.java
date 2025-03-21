package com.osm.oilproductionservice.dto;

import com.osm.oilproductionservice.enums.OliveLotStatus;

import java.time.LocalDateTime;
import java.util.Set;

public class DeliveryDto {

    private Long id; // ID of the delivery
    private String receiptNumber; // Receipt number
    private String lotNumber; // Lot number
    private LocalDateTime deliveryDate; // Delivery date
    private OliveLotStatus status; // Status of the olive lot (enum)
    private String globalLotNumber; // Global lot number
    private Float oliveQuantity; // Quantity of olives delivered
    private Float oilQuantity; // Quantity of oil extracted
    private RegionDto region; // ID of the region (custom type)
    private OliveVarietyDto variety;
    private String storageUnit;
    private SupplierDto supplier; // ID of the supplier
    private Float unitPrice; // Price per unit of olive oil
    private Float price; // Total price for the delivery
    private Float paidAmount; // Amount paid by the supplier
    private Float unpaidAmount; // Amount that remains unpaid
    private Set<QualityControlResultDto> qualityControlResults; // Expecting a collection

    public DeliveryDto() {
    }

    public DeliveryDto(Long id, String receiptNumber, String lotNumber, LocalDateTime deliveryDate, OliveLotStatus status, String globalLotNumber, Float oliveQuantity, Float oilQuantity, RegionDto region, OliveVarietyDto variety, String storageUnit, SupplierDto supplier, Float unitPrice, Float price, Float paidAmount, Float unpaidAmount, Set<QualityControlResultDto> qualityControlResults) {
        this.id = id;
        this.receiptNumber = receiptNumber;
        this.lotNumber = lotNumber;
        this.deliveryDate = deliveryDate;
        this.status = status;
        this.globalLotNumber = globalLotNumber;
        this.oliveQuantity = oliveQuantity;
        this.oilQuantity = oilQuantity;
        this.region = region;
        this.variety = variety;
        this.storageUnit = storageUnit;
        this.supplier = supplier;
        this.unitPrice = unitPrice;
        this.price = price;
        this.paidAmount = paidAmount;
        this.unpaidAmount = unpaidAmount;
        this.qualityControlResults = qualityControlResults;
    }

    public Set<QualityControlResultDto> getQualityControlResults() {
        return qualityControlResults;
    }

    public void setQualityControlResults(Set<QualityControlResultDto> qualityControlResults) {
        this.qualityControlResults = qualityControlResults;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public RegionDto getRegion() {
        return region;
    }

    public void setRegion(RegionDto region) {
        this.region = region;
    }

    public OliveVarietyDto getVariety() {
        return variety;
    }

    public void setVariety(OliveVarietyDto variety) {
        this.variety = variety;
    }

    public String getStorageUnit() {
        return storageUnit;
    }

    public void setStorageUnit(String storageUnit) {
        this.storageUnit = storageUnit;
    }

    public SupplierDto getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierDto supplier) {
        this.supplier = supplier;
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


}