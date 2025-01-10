package com.example.Practica.persistence.repository.products;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Practica.persistence.entity.products.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

   Optional<CategoryEntity> findByNombre(String nombre);

   boolean existsByNombre(String nombre);
}
