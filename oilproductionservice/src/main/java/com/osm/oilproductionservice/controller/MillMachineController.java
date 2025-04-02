package com.osm.oilproductionservice.controller;


import com.osm.oilproductionservice.dto.DeliveryDto;
import com.osm.oilproductionservice.dto.MillMachineDto;
import com.osm.oilproductionservice.model.Delivery;
import com.osm.oilproductionservice.model.MillMachine;
import com.osm.oilproductionservice.service.DeliveryService;
import com.xdev.xdevbase.controllers.impl.BaseControllerImpl;
import com.xdev.xdevbase.services.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/production/millers")
public class MillMachineController extends BaseControllerImpl<MillMachine, MillMachineDto, MillMachineDto> {

    private final DeliveryService deliveryService;

    public MillMachineController(BaseService<MillMachine, MillMachineDto, MillMachineDto>  baseService, ModelMapper modelMapper, DeliveryService deliveryService) {
        super(baseService, modelMapper);
        this.deliveryService = deliveryService;
    }
}
