package com.example.Practica.services.user;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.Practica.persistence.entity.user.UserEntity;
import com.example.Practica.persistence.repository.user.UserRepository;
import com.example.Practica.presentation.userResponse.dto.LoginRequestDTO;
import com.example.Practica.presentation.userResponse.dto.RegisterRequestDTO;
import com.example.Practica.presentation.userResponse.dto.UserRequestDTO;
import com.example.Practica.utils.userResponse.mappers.UserRegisterMapper;
import com.example.Practica.utils.userResponse.mappers.UserRequestMapper;
import com.example.Practica.utils.userResponse.validation.UserResponseValidation;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserResponseValidation userResponseValidation;

    // Inyectar la clase de validaciones
    public UserService(UserRepository userRepository, UserResponseValidation userResponseValidation) {
        this.userRepository = userRepository;
        this.userResponseValidation = userResponseValidation;
    }

    // ALL USERS WITH PAGINATION
    public Page<UserRequestDTO> findAllUsers(Pageable pageable) {

        if (pageable.getPageNumber() < 0) {
            throw new IllegalArgumentException("El número de página no puede ser negativo");
        }

        Page<UserEntity> users = userRepository.findAll(pageable);
        return users.map(user -> UserRequestMapper.INSTANCE.fromDTO(user));
    }



    // LOGIN
    public boolean loginUser(LoginRequestDTO loginRequestDTO) {
        return userRepository.findByEmail(loginRequestDTO.email())
                .map(user -> user.getPassword().equals(loginRequestDTO.password()))
                .orElse(false);
    }

    // CREATE
    @Transactional
    public RegisterRequestDTO registerUser(RegisterRequestDTO registerRequestDTO) {
        // Validar los datos del DTO
        if (!userResponseValidation.validateEmail(registerRequestDTO.email())) {
            throw new IllegalArgumentException(userResponseValidation.getEmailValidation());
        }
        if (!userResponseValidation.validatePassword(registerRequestDTO.password())) {
            throw new IllegalArgumentException(userResponseValidation.getPasswordValidation());
        }
        if (!userResponseValidation.validatePasswordConfirmation(registerRequestDTO.password(), registerRequestDTO.confirmPassword())) {
            throw new IllegalArgumentException(userResponseValidation.getPasswordConfirmationValidation());
        }
        if (!userResponseValidation.validateUsername(registerRequestDTO.username())) {
            throw new IllegalArgumentException(userResponseValidation.getUsernameValidation());
        }
        if (!userResponseValidation.validateLastName(registerRequestDTO.lastName())) {
            throw new IllegalArgumentException(userResponseValidation.getLastNameValidation());
        }
        if (!userResponseValidation.validateBirthDate(registerRequestDTO.birthDate())) {
            throw new IllegalArgumentException(userResponseValidation.getBirthDateValidation());
        }

        // CONVERTIR DTO A ENTITY
        UserEntity registerUser = UserRegisterMapper.INSTANCE.fromDTO(registerRequestDTO);
        userRepository.save(registerUser);
        
        // Retornar el DTO (o el mismo DTO o uno diferente si es necesario)
        return registerRequestDTO;
    }
}
