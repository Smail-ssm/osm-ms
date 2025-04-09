package com.osm.oilproductionservice.test;

import com.xdev.xdevbase.controllers.impl.BaseControllerImpl;
import com.xdev.xdevbase.services.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/production/test")

public class testController extends BaseControllerImpl<test, testDto, testDto> {
    public testController(BaseService<test, testDto, testDto> baseService, ModelMapper modelMapper) {
        super(baseService, modelMapper);
    }
}
