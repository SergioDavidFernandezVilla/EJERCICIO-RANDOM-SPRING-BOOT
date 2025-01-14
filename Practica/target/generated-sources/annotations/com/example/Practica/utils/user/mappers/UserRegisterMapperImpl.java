package com.example.Practica.utils.user.mappers;

import com.example.Practica.persistence.entity.user.UserEntity;
import com.example.Practica.presentation.userResponse.dto.RegisterRequestDTO;
import com.example.Practica.utils.userResponse.mappers.UserRegisterMapper;

import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-14T01:47:49+0000",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250107-1446, environment: Java 21.0.3 (N/A)"
)
@Component
public class UserRegisterMapperImpl implements UserRegisterMapper {

    @Override
    public UserEntity fromDTO(RegisterRequestDTO registerRequestDTO) {
        if ( registerRequestDTO == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.birthDate( registerRequestDTO.birthDate() );
        userEntity.confirmPassword( registerRequestDTO.confirmPassword() );
        userEntity.email( registerRequestDTO.email() );
        userEntity.lastName( registerRequestDTO.lastName() );
        userEntity.password( registerRequestDTO.password() );
        userEntity.username( registerRequestDTO.username() );

        return userEntity.build();
    }

    @Override
    public RegisterRequestDTO fromEntity(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        String email = null;
        String password = null;
        String confirmPassword = null;
        String username = null;
        String lastName = null;
        LocalDate birthDate = null;

        email = userEntity.getEmail();
        password = userEntity.getPassword();
        confirmPassword = userEntity.getConfirmPassword();
        username = userEntity.getUsername();
        lastName = userEntity.getLastName();
        birthDate = userEntity.getBirthDate();

        RegisterRequestDTO registerRequestDTO = new RegisterRequestDTO( email, password, confirmPassword, username, lastName, birthDate );

        return registerRequestDTO;
    }
}
