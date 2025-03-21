package com.osm.oilproductionservice.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "quality_control_result")
public class QualityControlResult implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // The identifier of the quality rule (e.g., could be a foreign key from a rule table or a code)
    @Column(name = "rule_id", nullable = false)
    private Long ruleId;

    // The value measured by the quality controller for this rule
    @Column(name = "measured_value", nullable = false)
    private Float measuredValue;

    // Many-to-One relationship: each result is associated with one Delivery.
    @ManyToOne(fetch = FetchType.LAZY)
     private Delivery delivery;

    // Constructors
    public QualityControlResult() {
    }

    public QualityControlResult(Long ruleId, Float measuredValue, Delivery delivery) {
        this.ruleId = ruleId;
        this.measuredValue = measuredValue;
        this.delivery = delivery;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public Float getMeasuredValue() {
        return measuredValue;
    }

    public void setMeasuredValue(Float measuredValue) {
        this.measuredValue = measuredValue;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}
