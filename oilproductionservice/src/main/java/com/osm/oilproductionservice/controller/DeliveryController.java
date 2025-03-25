package com.osm.oilproductionservice.controller;


import com.osm.oilproductionservice.dto.out.DeliveryDto;
import com.osm.oilproductionservice.model.Delivery;
import com.osm.oilproductionservice.service.DeliveryService;
import com.xdev.xdevbase.controllers.impl.BaseControllerImpl;
import com.xdev.xdevbase.services.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/production/deliveries")
public class DeliveryController extends BaseControllerImpl<Delivery, DeliveryDto, DeliveryDto> {

    private final DeliveryService deliveryService;

    public DeliveryController(BaseService<Delivery, DeliveryDto, DeliveryDto> baseService, ModelMapper modelMapper, DeliveryService deliveryService) {
        super(baseService, modelMapper);
        this.deliveryService = deliveryService;
    }


}
