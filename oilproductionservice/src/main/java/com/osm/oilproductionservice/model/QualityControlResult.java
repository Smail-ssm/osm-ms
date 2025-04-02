package com.osm.oilproductionservice.model;

import com.xdev.xdevbase.entities.BaseEntity;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "quality_control_result")
public class QualityControlResult extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;



    // The identifier of the quality rule (e.g., could be a foreign key from a rule table or a code)
     @ManyToOne(fetch = FetchType.LAZY)
    private QualityControlRule rule;

    // The value measured by the quality controller for this rule
    @Column(name = "measured_value", nullable = false)
    private Float measuredValue;

    // Many-to-One relationship: each result is associated with one Delivery.
    @ManyToOne(fetch = FetchType.LAZY)
     private Delivery delivery;

    // Constructors
    public QualityControlResult() {
    }

    public QualityControlResult(QualityControlRule rule, Float measuredValue, Delivery delivery) {
        this.rule = rule;
        this.measuredValue = measuredValue;
        this.delivery = delivery;
    }


    public QualityControlRule getRule() {
        return rule;
    }

    public void setRule(QualityControlRule ruleId) {
        this.rule = ruleId;
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
