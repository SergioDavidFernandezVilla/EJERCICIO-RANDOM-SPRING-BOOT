package com.example.Practica.persistence.repository.user;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Practica.persistence.entity.user.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    
    // FIND BY USERNAME
    Optional<UserEntity> findByUsername(String username);

    // FIND BY EMAIL
    Optional<UserEntity> findByEmail(String email);
}
