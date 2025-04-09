package com.osm.securityservice.userManagement.controller;


import com.osm.securityservice.userManagement.dtos.OUTDTO.RoleDTO;
import com.osm.securityservice.userManagement.models.Role;
import com.xdev.xdevbase.controllers.impl.BaseControllerImpl;
import com.xdev.xdevbase.services.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/security/role")
public class RoleController extends BaseControllerImpl<Role, RoleDTO, RoleDTO> {
    public RoleController(BaseService<Role, RoleDTO, RoleDTO> baseService, ModelMapper modelMapper) {
        super(baseService, modelMapper);
    }
}
