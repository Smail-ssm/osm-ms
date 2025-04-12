//package com.osm.oilproductionservice.model;
//
//import com.osm.oilproductionservice.enums.DeliveryType;
//import com.xdev.xdevbase.entities.BaseEntity;
//import jakarta.persistence.*;
//import org.hibernate.annotations.Cache;
//import org.hibernate.annotations.CacheConcurrencyStrategy;
//
//import java.io.Serializable;
//import java.time.LocalDateTime;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Table(name = "base_delivery")
//@Inheritance(strategy = InheritanceType.JOINED)
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
//public class UnifiedDelivery extends BaseEntity implements Serializable {
//    private String deliveryNumber;
//
//    @Enumerated(EnumType.STRING)
//    private DeliveryType deliveryType;
//
//    private String lotNumber;
//    private LocalDateTime deliveryDate;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    private BaseType region;
//    private float poidsBrute;
//    private float poidsNet;
//    private String matricule_camion;
//    private String etat_camion;
//    // *** NEW: SupplierInfo association ***
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Supplier supplierType;
//
//    // New: common quality control results for all deliveries
//    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<QualityControlResult> qualityControlResults = new HashSet<>();
//
//    public UnifiedDelivery(String deliveryNumber, DeliveryType deliveryType, String lotNumber, LocalDateTime deliveryDate, BaseType region, String matricule_camion, String etatCamion, Supplier supplierType, Set<QualityControlResult> qualityControlResults) {
//        this.deliveryNumber = deliveryNumber;
//        this.deliveryType = deliveryType;
//        this.lotNumber = lotNumber;
//        this.deliveryDate = deliveryDate;
//        this.region = region;
//        this.matricule_camion = matricule_camion;
//        etat_camion = etatCamion;
//        this.supplierType = supplierType;
//        this.qualityControlResults = qualityControlResults;
//    }
//
//    public UnifiedDelivery( ) {
//     }
//
//    public UnifiedDelivery(String deliveryNumber, DeliveryType deliveryType, String lotNumber, LocalDateTime deliveryDate, BaseType region, String matricule_camion, Supplier supplierType, SupplierInfo supplier, String etatCamion) {
//        this.deliveryNumber = deliveryNumber;
//        this.deliveryType = deliveryType;
//        this.lotNumber = lotNumber;
//        this.deliveryDate = deliveryDate;
//        this.region = region;
//        this.matricule_camion = matricule_camion;
//        this.supplierType = supplierType;
//        etat_camion = etatCamion;
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
//    public BaseType getRegion() {
//        return region;
//    }
//
//    public void setRegion(BaseType region) {
//        this.region = region;
//    }
//
//    public String getMatricule_camion() {
//        return matricule_camion;
//    }
//
//    public void setMatricule_camion(String matricule_camion) {
//        this.matricule_camion = matricule_camion;
//    }
//
//    public Supplier getSupplierType() {
//        return supplierType;
//    }
//
//    public void setSupplierType(Supplier supplierType) {
//        this.supplierType = supplierType;
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
