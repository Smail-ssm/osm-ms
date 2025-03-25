package com.osm.oilproductionservice.controller;

import com.osm.oilproductionservice.dto.out.SupplierDto;
import com.osm.oilproductionservice.model.Supplier;
import com.osm.oilproductionservice.service.SupplierService;
import com.xdev.xdevbase.controllers.impl.BaseControllerImpl;
import com.xdev.xdevbase.services.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/production/suppliers")
public class SupplierController extends BaseControllerImpl<Supplier, SupplierDto, SupplierDto> {

    @Autowired
    private SupplierService supplierService;

    public SupplierController(BaseService<Supplier, SupplierDto, SupplierDto> baseService, ModelMapper modelMapper, SupplierService supplierService) {
        super(baseService, modelMapper);
        this.supplierService = supplierService;
    }


}
