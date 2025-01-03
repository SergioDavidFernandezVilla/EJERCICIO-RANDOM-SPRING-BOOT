package com.example.Practica.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Practica.persistence.entity.MarcaEntity;

@Repository
public interface MarcaRepository extends JpaRepository<MarcaEntity, Long> {

    Iterable<MarcaEntity> findByMarcaContainingIgnoreCase(String marca);
    
}
