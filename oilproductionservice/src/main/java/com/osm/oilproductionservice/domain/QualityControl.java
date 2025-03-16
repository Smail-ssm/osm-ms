package com.osm.oilproductionservice.domain;


import jakarta.persistence.*;
 import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "quality_control")
public class QualityControl implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "date", nullable = false)
    private Instant date;  // Date of quality control

    @NotNull
    @Column(name = "time", nullable = false)
    private Instant time;  // Time of quality control

    @NotNull
    @Column(name = "supplier_id", nullable = false)
    private String supplierId;  // Supplier identification

    @Column(name = "reception_receipt_number")
    private String receptionReceiptNumber;  // Reception receipt number

    @Column(name = "truck_condition")
    private String truckCondition;  // Condition of the truck (compliant or not)

    @Column(name = "crate_condition")
    private String crateCondition;  // Condition of the crates/sacks (compliant or not)

    @Column(name = "infestation_percentage")
    private Float infestationPercentage;  // Percentage of infestation

    @Column(name = "fermentation_percentage")
    private Float fermentationPercentage;  // Percentage of fermentation

    @Column(name = "moisture_content")
    private Float moistureContent;  // Percentage of moisture content

    @Column(name = "maturity_level")
    private String maturityLevel;  // Maturity level (e.g., fully ripe)

    @Column(name = "quality_score")
    private Float qualityScore;  // Quality score of the olives

    @Column(name = "foreign_bodies_trace")
    private Boolean foreignBodiesTrace;  // Whether there are foreign bodies (yes/no)

    @Column(name = "texture_state")
    private String textureState;  // State of texture (soft or dry)

    @Column(name = "damage_percentage")
    private Float damagePercentage;  // Percentage of damaged olives

    @Column(name = "allergen_trace")
    private Boolean allergenTrace;  // Whether there is any trace of allergens (yes/no)

    @Column(name = "final_decision")
    private String finalDecision;  // Final decision (e.g., accepted, refused)

    @Column(name = "signature")
    private String signature;  // Signature of the quality control person

    // Getters and Setters for each attribute

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getReceptionReceiptNumber() {
        return receptionReceiptNumber;
    }

    public void setReceptionReceiptNumber(String receptionReceiptNumber) {
        this.receptionReceiptNumber = receptionReceiptNumber;
    }

    public String getTruckCondition() {
        return truckCondition;
    }

    public void setTruckCondition(String truckCondition) {
        this.truckCondition = truckCondition;
    }

    public String getCrateCondition() {
        return crateCondition;
    }

    public void setCrateCondition(String crateCondition) {
        this.crateCondition = crateCondition;
    }

    public Float getInfestationPercentage() {
        return infestationPercentage;
    }

    public void setInfestationPercentage(Float infestationPercentage) {
        this.infestationPercentage = infestationPercentage;
    }

    public Float getFermentationPercentage() {
        return fermentationPercentage;
    }

    public void setFermentationPercentage(Float fermentationPercentage) {
        this.fermentationPercentage = fermentationPercentage;
    }

    public Float getMoistureContent() {
        return moistureContent;
    }

    public void setMoistureContent(Float moistureContent) {
        this.moistureContent = moistureContent;
    }

    public String getMaturityLevel() {
        return maturityLevel;
    }

    public void setMaturityLevel(String maturityLevel) {
        this.maturityLevel = maturityLevel;
    }

    public Float getQualityScore() {
        return qualityScore;
    }

    public void setQualityScore(Float qualityScore) {
        this.qualityScore = qualityScore;
    }

    public Boolean getForeignBodiesTrace() {
        return foreignBodiesTrace;
    }

    public void setForeignBodiesTrace(Boolean foreignBodiesTrace) {
        this.foreignBodiesTrace = foreignBodiesTrace;
    }

    public String getTextureState() {
        return textureState;
    }

    public void setTextureState(String textureState) {
        this.textureState = textureState;
    }

    public Float getDamagePercentage() {
        return damagePercentage;
    }

    public void setDamagePercentage(Float damagePercentage) {
        this.damagePercentage = damagePercentage;
    }

    public Boolean getAllergenTrace() {
        return allergenTrace;
    }

    public void setAllergenTrace(Boolean allergenTrace) {
        this.allergenTrace = allergenTrace;
    }

    public String getFinalDecision() {
        return finalDecision;
    }

    public void setFinalDecision(String finalDecision) {
        this.finalDecision = finalDecision;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}