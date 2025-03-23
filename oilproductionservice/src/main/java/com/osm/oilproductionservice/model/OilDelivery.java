package com.osm.oilproductionservice.model;

import com.osm.oilproductionservice.enums.OliveLotStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class OilDelivery {

    private static final long serialVersionUID = 1L;
    // One-to-One relationship with QualityControl entity
    @OneToMany(mappedBy = "delivery")
    public Set<QualityControlResult> qualityControlResults = new HashSet<>();
    @Id
    private String receiptNumber;
    private String lotNumber;
    private LocalDateTime deliveryDate;
    private LocalDateTime triturationDate;
    @Enumerated(EnumType.STRING)  // Use EnumType.STRING to persist the enum as a string
    private OliveLotStatus status;  // Enum field to store the status of the olive lot
    private String globalLotNumber;
    private Float oliveQuantity;
    private Float oilQuantity;
    @ManyToOne(fetch = FetchType.LAZY)
    private BaseType region;
    @ManyToOne(fetch = FetchType.LAZY)
    private BaseType oliveVariety;
    private String storageUnit;
    @ManyToOne(optional = false)
    private Supplier supplier;
    // New Attributes
    @Column(name = "unit_price")
    private Float unitPrice;      // Price per unit of olive oil
    @Column(name = "price")
    private Float price;          // Total price for the delivery
    @Column(name = "paid_amount")
    private Float paidAmount;     // Amount paid by the supplier
    @Column(name = "unpaid_amount")
    private Float unpaidAmount;   }
