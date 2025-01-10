package com.example.Practica.persistence.repository.products;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Practica.persistence.entity.products.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    @Query("SELECT p FROM ProductEntity p JOIN FETCH p.categoria c JOIN FETCH p.marca m JOIN FETCH p.image i")
    Page<ProductEntity> findAllWithCategoryAndBrand(Pageable pageable);

    boolean existsByNombre(String nombre);
    Optional<ProductEntity> findByNombre(String nombre);
}
