package com.osm.oilproductionservice.test;

import com.xdev.xdevbase.repos.BaseRepository;
import com.xdev.xdevbase.services.BaseService;
import com.xdev.xdevbase.services.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class testService extends BaseServiceImpl<test,testDto,testDto> {
    public testService(BaseRepository<test> repository, ModelMapper modelMapper) {
        super(repository, modelMapper);
    }
}
