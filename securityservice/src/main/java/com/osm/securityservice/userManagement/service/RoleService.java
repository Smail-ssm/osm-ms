package com.osm.securityservice.userManagement.service;


import com.osm.securityservice.userManagement.data.RoleRepository;
import com.osm.securityservice.userManagement.dtos.OUTDTO.RoleDTO;
import com.osm.securityservice.userManagement.models.Role;
import com.xdev.xdevbase.repos.BaseRepository;
import com.xdev.xdevbase.services.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends BaseServiceImpl<Role, RoleDTO, RoleDTO> {
    private final RoleRepository roleRepository;

    protected RoleService(BaseRepository<Role> repository, ModelMapper modelMapper, RoleRepository roleRepository) {
        super(repository, modelMapper);
        this.roleRepository = roleRepository;
    }
}
