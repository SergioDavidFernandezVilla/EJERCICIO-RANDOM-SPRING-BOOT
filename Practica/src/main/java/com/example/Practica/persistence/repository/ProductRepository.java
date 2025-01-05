package com.example.Practica.persistence.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Practica.persistence.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    @Query("SELECT p FROM ProductEntity p " +
    "JOIN FETCH p.categoria c " +  // Hacer JOIN con categoria
    "JOIN FETCH p.marca m"  +       // Hacer JOIN con marca
    "JOIN FETCH p.image i"         // Hacer JOIN con image
    )
    Page<ProductEntity> findAllWithCategoryAndBrand(Pageable pageable);
}
