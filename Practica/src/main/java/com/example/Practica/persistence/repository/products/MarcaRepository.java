package com.example.Practica.persistence.repository.products;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Practica.persistence.entity.products.MarcaEntity;

@Repository
public interface MarcaRepository extends JpaRepository<MarcaEntity, Long> {    
    Optional<MarcaEntity> findByNombre(String nombre);

    boolean existsByNombre(String nombre);
}
