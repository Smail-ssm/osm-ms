package com.osm.oilproductionservice.service;

import com.osm.oilproductionservice.model.Supplier;
import com.osm.oilproductionservice.dto.SupplierDto;
import com.osm.oilproductionservice.repository.SupplierRepository;
import com.xdev.xdevbase.repos.BaseRepository;
import com.xdev.xdevbase.services.BaseService;
import com.xdev.xdevbase.services.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService  extends BaseServiceImpl<Supplier,SupplierDto,SupplierDto> {
    public SupplierService(BaseRepository<Supplier> repository, ModelMapper modelMapper) {
        super(repository, modelMapper);
    }

}