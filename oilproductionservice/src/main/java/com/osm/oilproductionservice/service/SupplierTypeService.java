package com.osm.oilproductionservice.service;

import com.osm.oilproductionservice.dto.SupplierTypeDto;
import com.osm.oilproductionservice.model.SupplierType;
import com.xdev.xdevbase.repos.BaseRepository;
import com.xdev.xdevbase.services.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SupplierTypeService extends BaseServiceImpl<SupplierType, SupplierTypeDto, SupplierTypeDto> {
    public SupplierTypeService(BaseRepository<SupplierType> repository, ModelMapper modelMapper) {
        super(repository, modelMapper);
    }

}