package com.osm.oilproductionservice.model;

import com.osm.oilproductionservice.constants.OilType;
import com.osm.oilproductionservice.constants.StorageStatus;
import com.xdev.xdevbase.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

@Entity
public class StorageUnit extends BaseEntity {
    private String name;
    private String location;
    private String description;
    private Double maxCapacity;
    private Double currentVolume;
    private LocalDateTime nextMaintenanceDate;
    private LocalDateTime lastInspectionDate;
    @Enumerated(EnumType.STRING)
    private OilType oilType;
    @Enumerated(EnumType.STRING)
    private StorageStatus status;
    private LocalDateTime lastFillDate;
    private LocalDateTime lastEmptyDate;

    public StorageUnit() {
    }

    public StorageUnit(String name, String location, String description, Double maxCapacity, Double currentVolume, LocalDateTime nextMaintenanceDate, LocalDateTime lastInspectionDate, OilType oilType, StorageStatus status, LocalDateTime lastFillDate, LocalDateTime lastEmptyDate) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.maxCapacity = maxCapacity;
        this.currentVolume = currentVolume;
        this.nextMaintenanceDate = nextMaintenanceDate;
        this.lastInspectionDate = lastInspectionDate;
        this.oilType = oilType;
        this.status = status;
        this.lastFillDate = lastFillDate;
        this.lastEmptyDate = lastEmptyDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Double maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Double getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(Double currentVolume) {
        this.currentVolume = currentVolume;
    }

    public LocalDateTime getNextMaintenanceDate() {
        return nextMaintenanceDate;
    }

    public void setNextMaintenanceDate(LocalDateTime nextMaintenanceDate) {
        this.nextMaintenanceDate = nextMaintenanceDate;
    }

    public LocalDateTime getLastInspectionDate() {
        return lastInspectionDate;
    }

    public void setLastInspectionDate(LocalDateTime lastInspectionDate) {
        this.lastInspectionDate = lastInspectionDate;
    }

    public OilType getOilType() {
        return oilType;
    }

    public void setOilType(OilType oilType) {
        this.oilType = oilType;
    }

    public StorageStatus getStatus() {
        return status;
    }

    public void setStatus(StorageStatus status) {
        this.status = status;
    }

    public LocalDateTime getLastFillDate() {
        return lastFillDate;
    }

    public void setLastFillDate(LocalDateTime lastFillDate) {
        this.lastFillDate = lastFillDate;
    }

    public LocalDateTime getLastEmptyDate() {
        return lastEmptyDate;
    }

    public void setLastEmptyDate(LocalDateTime lastEmptyDate) {
        this.lastEmptyDate = lastEmptyDate;
    }
}
