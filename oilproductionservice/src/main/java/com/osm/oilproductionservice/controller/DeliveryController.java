package com.osm.oilproductionservice.controller;

import com.osm.oilproductionservice.dto.ApiResponse;
import com.osm.oilproductionservice.dto.DeliveryDto;
import com.osm.oilproductionservice.dto.StorageUnitDto;
import com.osm.oilproductionservice.model.Delivery;
import com.osm.oilproductionservice.model.StorageUnit;
import com.osm.oilproductionservice.service.DeliveryService;
import com.xdev.xdevbase.controllers.impl.BaseControllerImpl;
import com.xdev.xdevbase.repos.BaseRepository;
import com.xdev.xdevbase.services.BaseService;
import com.xdev.xdevbase.services.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/production/deliveries")
public class DeliveryController extends BaseControllerImpl<Delivery, DeliveryDto, DeliveryDto> {

    private final DeliveryService deliveryService;

    public DeliveryController(BaseService<Delivery, DeliveryDto, DeliveryDto> baseService, ModelMapper modelMapper, DeliveryService deliveryService) {
        super(baseService, modelMapper);
        this.deliveryService = deliveryService;
    }
}
