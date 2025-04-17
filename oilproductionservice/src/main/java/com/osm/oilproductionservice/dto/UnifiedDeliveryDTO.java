package com.osm.oilproductionservice.dto;

import com.osm.oilproductionservice.enums.DeliveryType;
import com.osm.oilproductionservice.enums.OliveLotStatus;
import com.osm.oilproductionservice.model.QualityControlResult;
import com.osm.oilproductionservice.model.UnifiedDelivery;
import com.xdev.xdevbase.dtos.BaseDto;
import jakarta.annotation.Nullable;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * DTO for UnifiedDelivery.
 */
public class UnifiedDeliveryDTO extends BaseDto<UnifiedDelivery> {

    // --- Common Fields ---
    private String deliveryNumber;
    private DeliveryType deliveryType;
    private String lotNumber;
    private LocalDateTime deliveryDate;

    // For the DTO, you may choose to represent complex objects (e.g. BaseType region) as Strings (e.g., region name)
    private BaseTypeDto region;
    private float poidsBrute;
    private float poidsNet;
    private String matriculeCamion;
    private String etatCamion;
    // Represent supplierType as a string for simplification (or use a nested DTO if needed)

    private SupplierDto supplier;
    // Quality control results can be represented as IDs, summaries, or a list of DTOs

    // --- Oil Delivery Specific Fields ---
    // This field is common to both oil and olive deliveries if needed
    private String globalLotNumber;
    // Represent oil-specific associations (could be names or IDs)

    private BaseTypeDto oilVariety;

    private Float oilQuantity;

    private Float unitPrice;

    private Float price;

    private Float paidAmount;

    private Float unpaidAmount;

    private BaseTypeDto oilType;

    // --- Olive Delivery Specific Fields ---

    private LocalDateTime trtDate;


    private BaseTypeDto oliveVariety;

    private int sackCount;

    private BaseTypeDto oliveType;

    private OliveLotStatus status;

    private Float rendement;


    private Float oliveQuantity;

    private String parcel;

    public UnifiedDeliveryDTO(String deliveryNumber, DeliveryType deliveryType, String lotNumber, LocalDateTime deliveryDate, BaseTypeDto region, float poidsBrute, float poidsNet, String matriculeCamion, String etatCamion, SupplierDto supplier, String globalLotNumber, BaseTypeDto oilVariety, Float oilQuantity, Float unitPrice, Float price, Float paidAmount, Float unpaidAmount, BaseTypeDto oilType, LocalDateTime trtDate, BaseTypeDto oliveVariety, int sackCount, BaseTypeDto oliveType, OliveLotStatus status, Float rendement, Float oliveQuantity, String parcel) {
        this.deliveryNumber = deliveryNumber;
        this.deliveryType = deliveryType;
        this.lotNumber = lotNumber;
        this.deliveryDate = deliveryDate;
        this.region = region;
        this.poidsBrute = poidsBrute;
        this.poidsNet = poidsNet;
        this.matriculeCamion = matriculeCamion;
        this.etatCamion = etatCamion;
        this.supplier = supplier;
        this.globalLotNumber = globalLotNumber;
        this.oilVariety = oilVariety;
        this.oilQuantity = oilQuantity;
        this.unitPrice = unitPrice;
        this.price = price;
        this.paidAmount = paidAmount;
        this.unpaidAmount = unpaidAmount;
        this.oilType = oilType;
        this.trtDate = trtDate;
        this.oliveVariety = oliveVariety;
        this.sackCount = sackCount;
        this.oliveType = oliveType;
        this.status = status;
        this.rendement = rendement;

        this.oliveQuantity = oliveQuantity;
        this.parcel = parcel;
    }

    public String getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(String deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
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

    public BaseTypeDto getRegion() {
        return region;
    }

    public void setRegion(BaseTypeDto region) {
        this.region = region;
    }

    public float getPoidsBrute() {
        return poidsBrute;
    }

    public void setPoidsBrute(float poidsBrute) {
        this.poidsBrute = poidsBrute;
    }

    public float getPoidsNet() {
        return poidsNet;
    }

    public void setPoidsNet(float poidsNet) {
        this.poidsNet = poidsNet;
    }

    public String getMatriculeCamion() {
        return matriculeCamion;
    }

    public void setMatriculeCamion(String matriculeCamion) {
        this.matriculeCamion = matriculeCamion;
    }

    public String getEtatCamion() {
        return etatCamion;
    }

    public void setEtatCamion(String etatCamion) {
        this.etatCamion = etatCamion;
    }

    public SupplierDto getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierDto supplier) {
        this.supplier = supplier;
    }

    public String getGlobalLotNumber() {
        return globalLotNumber;
    }

    public void setGlobalLotNumber(String globalLotNumber) {
        this.globalLotNumber = globalLotNumber;
    }

    public BaseTypeDto getOilVariety() {
        return oilVariety;
    }

    public void setOilVariety(BaseTypeDto oilVariety) {
        this.oilVariety = oilVariety;
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


    public BaseTypeDto getOilType() {
        return oilType;
    }

    public void setOilType(BaseTypeDto oilType) {
        this.oilType = oilType;
    }

    public LocalDateTime getTrtDate() {
        return trtDate;
    }

    public void setTrtDate(LocalDateTime trtDate) {
        this.trtDate = trtDate;
    }


    public BaseTypeDto getOliveVariety() {
        return oliveVariety;
    }

    public void setOliveVariety(BaseTypeDto oliveVariety) {
        this.oliveVariety = oliveVariety;
    }

    public int getSackCount() {
        return sackCount;
    }

    public void setSackCount(int sackCount) {
        this.sackCount = sackCount;
    }

    public BaseTypeDto getOliveType() {
        return oliveType;
    }

    public void setOliveType(BaseTypeDto oliveType) {
        this.oliveType = oliveType;
    }

    public OliveLotStatus getStatus() {
        return status;
    }

    public void setStatus(OliveLotStatus status) {
        this.status = status;
    }

    public Float getRendement() {
        return rendement;
    }

    public void setRendement(Float rendement) {
        this.rendement = rendement;
    }


    public Float getOliveQuantity() {
        return oliveQuantity;
    }

    public void setOliveQuantity(Float oliveQuantity) {
        this.oliveQuantity = oliveQuantity;
    }

    public String getParcel() {
        return parcel;
    }

    public void setParcel(String parcel) {
        this.parcel = parcel;
    }
}
