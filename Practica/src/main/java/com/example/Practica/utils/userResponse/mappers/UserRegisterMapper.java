package com.example.Practica.utils.userResponse.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.Practica.persistence.entity.user.UserEntity;
import com.example.Practica.presentation.userResponse.dto.RegisterRequestDTO;

@Mapper(componentModel = "spring")
public interface UserRegisterMapper {
    
    // Instancia del mapper generada por MapStruct
    UserRegisterMapper INSTANCE = Mappers.getMapper(UserRegisterMapper.class);
    

    // DTO a Entity
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "permissions", ignore = true)
    @Mapping(target = "id", ignore = true)
    UserEntity fromDTO(RegisterRequestDTO registerRequestDTO);

    
    // Entity a DTO
    RegisterRequestDTO fromEntity(UserEntity userEntity);
}
