package com.osm.oilproductionservice.controller;

import com.osm.oilproductionservice.dto.SupplierTypeDto;
import com.osm.oilproductionservice.model.SupplierType;
import com.osm.oilproductionservice.service.SupplierTypeService;
import com.xdev.xdevbase.controllers.impl.BaseControllerImpl;
import com.xdev.xdevbase.services.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/production/suppliers_type")
public class SupplierTypeController extends BaseControllerImpl<SupplierType, SupplierTypeDto, SupplierTypeDto> {

    @Autowired
    private SupplierTypeService supplierService;

    public SupplierTypeController(BaseService<SupplierType, SupplierTypeDto, SupplierTypeDto> baseService, ModelMapper modelMapper, SupplierTypeService supplierService) {
        super(baseService, modelMapper);
        this.supplierService = supplierService;
    }


}
