package com.example.Practica.utils.userResponse.mappers;

import com.example.Practica.persistence.entity.user.UserEntity;
import com.example.Practica.presentation.userResponse.dto.UserRequestDTO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-14T04:21:53+0000",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250107-1446, environment: Java 21.0.3 (N/A)"
)
@Component
public class UserRequestMapperImpl implements UserRequestMapper {

    @Override
    public UserEntity fromEntity(UserRequestDTO userRequestDTO) {
        if ( userRequestDTO == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.birthDate( userRequestDTO.birthDate() );
        userEntity.confirmPassword( userRequestDTO.confirmPassword() );
        userEntity.email( userRequestDTO.email() );
        userEntity.id( userRequestDTO.id() );
        userEntity.lastName( userRequestDTO.lastName() );
        userEntity.password( userRequestDTO.password() );
        userEntity.username( userRequestDTO.username() );

        return userEntity.build();
    }

    @Override
    public UserRequestDTO fromDTO(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        LocalDateTime created_at = null;
        LocalDateTime updated_at = null;
        UUID id = null;
        String email = null;
        String password = null;
        String confirmPassword = null;
        String username = null;
        String lastName = null;
        LocalDate birthDate = null;

        created_at = userEntity.getCreatedAt();
        updated_at = userEntity.getUpdatedAt();
        id = userEntity.getId();
        email = userEntity.getEmail();
        password = userEntity.getPassword();
        confirmPassword = userEntity.getConfirmPassword();
        username = userEntity.getUsername();
        lastName = userEntity.getLastName();
        birthDate = userEntity.getBirthDate();

        UserRequestDTO userRequestDTO = new UserRequestDTO( id, email, password, confirmPassword, username, lastName, birthDate, created_at, updated_at );

        return userRequestDTO;
    }
}
