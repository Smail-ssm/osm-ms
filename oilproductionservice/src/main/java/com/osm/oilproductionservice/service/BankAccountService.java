package com.osm.oilproductionservice.service;

import com.osm.oilproductionservice.dto.BankAccountDto;
import com.osm.oilproductionservice.enums.TypeCategory;
import com.osm.oilproductionservice.model.BankAccount;
import com.osm.oilproductionservice.model.BaseType;
import com.osm.oilproductionservice.repository.GenericRepository;
import com.xdev.xdevbase.repos.BaseRepository;
import com.xdev.xdevbase.services.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BankAccountService extends BaseServiceImpl<BankAccount, BankAccountDto, BankAccountDto> {
    private final GenericRepository genericRepository;

    public BankAccountService(BaseRepository<BankAccount> repository, ModelMapper modelMapper, GenericRepository genericRepository) {
        super(repository, modelMapper);
        this.genericRepository = genericRepository;
    }


    public List<BaseType> getAllTypes(TypeCategory type) {

        return this.genericRepository.findAllByType(type);
    }
}
