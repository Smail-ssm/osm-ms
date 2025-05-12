package com.osm.oilproductionservice.controller;


import com.osm.oilproductionservice.dto.UnifiedDeliveryDTO;
import com.osm.oilproductionservice.model.UnifiedDelivery;
import com.osm.oilproductionservice.service.UnifiedDeliveryService;
import com.xdev.xdevbase.controllers.AdvancedSearchController;
import com.xdev.xdevbase.controllers.impl.BaseControllerImpl;
import com.xdev.xdevbase.services.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/production/deliveries")
@CrossOrigin
public class UnifiedDeliveryController extends BaseControllerImpl<UnifiedDelivery, UnifiedDeliveryDTO, UnifiedDeliveryDTO> implements
        AdvancedSearchController<UnifiedDelivery, UnifiedDeliveryDTO> {

    private final UnifiedDeliveryService UnifiedDeliveryService;

    public UnifiedDeliveryController(BaseService<UnifiedDelivery, UnifiedDeliveryDTO, UnifiedDeliveryDTO> baseService, ModelMapper modelMapper, UnifiedDeliveryService UnifiedDeliveryService) {
        super(baseService, modelMapper);
        this.UnifiedDeliveryService = UnifiedDeliveryService;
    }




}
