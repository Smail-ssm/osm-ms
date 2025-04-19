package com.osm.oilproductionservice.controller;


import com.osm.oilproductionservice.dto.BankAccountDto;
import com.osm.oilproductionservice.model.BankAccount;
import com.xdev.xdevbase.controllers.impl.BaseControllerImpl;
import com.xdev.xdevbase.services.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/production/banks")
@CrossOrigin
public class BankAccountController extends BaseControllerImpl<BankAccount, BankAccountDto, BankAccountDto> {


    public BankAccountController(BaseService<BankAccount, BankAccountDto, BankAccountDto> baseService, ModelMapper modelMapper) {
        super(baseService, modelMapper);
    }


}
