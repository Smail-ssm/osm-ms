package com.osm.oilproductionservice.controller;

import com.osm.oilproductionservice.dto.SupplierDto;
import com.osm.oilproductionservice.model.Supplier;
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
public class SupplierTypeController extends BaseControllerImpl<Supplier, SupplierDto, SupplierDto> {

    @Autowired
    private SupplierTypeService supplierService;

    public SupplierTypeController(BaseService<Supplier, SupplierDto, SupplierDto> baseService, ModelMapper modelMapper, SupplierTypeService supplierService) {
        super(baseService, modelMapper);
        this.supplierService = supplierService;
    }


}
