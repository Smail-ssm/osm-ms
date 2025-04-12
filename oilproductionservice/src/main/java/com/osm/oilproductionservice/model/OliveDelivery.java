//package com.osm.oilproductionservice.model;
//
//import com.osm.oilproductionservice.enums.OliveLotStatus;
//import com.osm.oilproductionservice.enums.OperationType;
//import jakarta.persistence.*;
//
//import java.time.LocalDateTime;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Table(name = "olive_delivery")
//public class UnifiedDelivery extends UnifiedDelivery {
//
//    private LocalDateTime trtDate;
//    @Enumerated(EnumType.STRING)
//    private OperationType operationType;
//    @ManyToOne(fetch = FetchType.LAZY)
//    private BaseType oliveVariety;
//
//    private int sackCount;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    private BaseType oliveType;
//
//    private String globalLotNumber;
//
//    @Enumerated(EnumType.STRING)
//    private OliveLotStatus status;
//
//    public UnifiedDelivery() {
//    }
//
//    // Full-argument constructor (example)
//    public UnifiedDelivery(LocalDateTime trtDate, Float rendement, MillMachine millMachine, Float oliveQuantity, BaseType oliveVariety, Integer sackCount, BaseType oliveType, String parcel, String globalLotNumber, OliveLotStatus status, Set<QualityControlResult> qualityControlResults) {
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
//        this.qualityControlResults = qualityControlResults;
//    }
//
//    // Getters and setters
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
//    public MillMachine getMillMachine() {
//        return millMachine;
//    }
//
//    public void setMillMachine(MillMachine millMachine) {
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
//    public BaseType getOliveVariety() {
//        return oliveVariety;
//    }
//
//    public void setOliveVariety(BaseType oliveVariety) {
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
//    public BaseType getOliveType() {
//        return oliveType;
//    }
//
//    public void setOliveType(BaseType oliveType) {
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
//    public Set<QualityControlResult> getQualityControlResults() {
//        return qualityControlResults;
//    }
//
//    public void setQualityControlResults(Set<QualityControlResult> qualityControlResults) {
//        this.qualityControlResults = qualityControlResults;
//    }
//}
