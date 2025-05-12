package com.osm.oilproductionservice.controller;

import com.osm.oilproductionservice.dto.SupplierDto;
import com.osm.oilproductionservice.model.Supplier;
import com.osm.oilproductionservice.service.SupplierTypeService;
import com.xdev.xdevbase.controllers.AdvancedSearchController;
import com.xdev.xdevbase.controllers.impl.BaseControllerImpl;
import com.xdev.xdevbase.services.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/production/suppliers_type")
public class SupplierTypeController extends BaseControllerImpl<Supplier, SupplierDto, SupplierDto>
        implements AdvancedSearchController<Supplier, SupplierDto> {


    public SupplierTypeController(BaseService<Supplier, SupplierDto, SupplierDto> baseService, ModelMapper modelMapper, SupplierTypeService supplierService) {
        super(baseService, modelMapper);
    }
}
