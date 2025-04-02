package com.osm.oilproductionservice.service;

import com.osm.oilproductionservice.model.Supplier;
import com.osm.oilproductionservice.dto.SupplierDto;
import com.xdev.xdevbase.repos.BaseRepository;
import com.xdev.xdevbase.services.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SupplierService  extends BaseServiceImpl<Supplier,SupplierDto,SupplierDto> {
    public SupplierService(BaseRepository<Supplier> repository, ModelMapper modelMapper) {
        super(repository, modelMapper);
    }

}