package com.osm.oilproductionservice.service;

import com.osm.oilproductionservice.dto.StorageUnitDto;
import com.osm.oilproductionservice.model.StorageUnit;
import com.osm.oilproductionservice.repository.StorageUnitRepo;
import com.xdev.xdevbase.repos.BaseRepository;
import com.xdev.xdevbase.services.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StorageUnitService extends BaseServiceImpl<StorageUnit, StorageUnitDto, StorageUnitDto> {
    private final StorageUnitRepo storageUnitRepo;

    public StorageUnitService(BaseRepository<StorageUnit> repository, ModelMapper modelMapper, StorageUnitRepo storageUnitRepo) {
        super(repository, modelMapper);
        this.storageUnitRepo = storageUnitRepo;
    }
}
