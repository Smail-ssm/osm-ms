package com.osm.securityservice.service.mapper;

import org.mapstruct.*;
import com.osm.securityservice.domain.User;
import com.osm.securityservice.service.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User user);
    User toEntity(UserDTO userDTO);
}
