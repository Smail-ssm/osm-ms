package com.osm.oilproductionservice.dto;

import com.osm.oilproductionservice.model.MachinePlan;
import com.xdev.xdevbase.dtos.BaseDto;

import java.time.LocalDateTime;

public class MachinePlanDto extends BaseDto<MachinePlan> {

    private MillMachineDto machine;
    private DeliveryDto delivery;
    private LocalDateTime plannedStartTime;
    private LocalDateTime plannedEndTime;
    private String status;

    // Optional: include delivery info for display
    private String receiptNumber;
    private String lotNumber;

    public MillMachineDto getMachine() {
        return machine;
    }

    public void setMachine(MillMachineDto machine) {
        this.machine = machine;
    }

    public DeliveryDto getDelivery() {
        return delivery;
    }

    public void setDelivery(DeliveryDto delivery) {
        this.delivery = delivery;
    }

    public LocalDateTime getPlannedStartTime() {
        return plannedStartTime;
    }

    public void setPlannedStartTime(LocalDateTime plannedStartTime) {
        this.plannedStartTime = plannedStartTime;
    }

    public LocalDateTime getPlannedEndTime() {
        return plannedEndTime;
    }

    public void setPlannedEndTime(LocalDateTime plannedEndTime) {
        this.plannedEndTime = plannedEndTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public MachinePlanDto() {
    }

    public MachinePlanDto(MillMachineDto machine, DeliveryDto delivery, LocalDateTime plannedStartTime, LocalDateTime plannedEndTime, String status, String receiptNumber, String lotNumber) {
        this.machine = machine;
        this.delivery = delivery;
        this.plannedStartTime = plannedStartTime;
        this.plannedEndTime = plannedEndTime;
        this.status = status;
        this.receiptNumber = receiptNumber;
        this.lotNumber = lotNumber;
    }
}
