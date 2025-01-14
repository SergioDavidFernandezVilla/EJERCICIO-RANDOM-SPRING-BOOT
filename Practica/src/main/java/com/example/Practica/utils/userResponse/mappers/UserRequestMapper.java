package com.example.Practica.utils.userResponse.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.Practica.persistence.entity.user.UserEntity;
import com.example.Practica.presentation.userResponse.dto.UserRequestDTO;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {
    
    UserRequestMapper INSTANCE = Mappers.getMapper(UserRequestMapper.class);

    @Mapping(target = "permissions", ignore = true)
    @Mapping(target = "roles", ignore = true)
    UserEntity fromEntity(UserRequestDTO userRequestDTO);

    @Mapping(target = "created_at", source = "createdAt")
    @Mapping(target = "updated_at", source = "updatedAt")
    UserRequestDTO fromDTO(UserEntity userEntity);
}
