package com.osm.oilproductionservice.service;

import com.osm.oilproductionservice.dto.MillMachineDto;
import com.osm.oilproductionservice.model.MillMachine;
import com.osm.oilproductionservice.repository.MillMachineRepository;
import com.xdev.xdevbase.services.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MillMachineService extends BaseServiceImpl<MillMachine, MillMachineDto, MillMachineDto> {
    private final MillMachineRepository millMachineRepository;

    public MillMachineService(MillMachineRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper);
        this.millMachineRepository = repository;
    }
}
