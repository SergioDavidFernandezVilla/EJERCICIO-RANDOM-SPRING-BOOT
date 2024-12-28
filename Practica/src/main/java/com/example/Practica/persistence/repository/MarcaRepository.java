package com.example.Practica.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Practica.persistence.entity.MarcaEntity;

@Repository
public interface MarcaRepository extends CrudRepository<MarcaEntity, Long> {
    
}
