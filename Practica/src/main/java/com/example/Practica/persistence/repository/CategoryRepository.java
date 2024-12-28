package com.example.Practica.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.Practica.persistence.entity.CategoryEntity;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
    
}
