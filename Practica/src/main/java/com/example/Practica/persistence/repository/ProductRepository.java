package com.example.Practica.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Practica.persistence.entity.ProductEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    ProductEntity findByUsername(String username);
}
