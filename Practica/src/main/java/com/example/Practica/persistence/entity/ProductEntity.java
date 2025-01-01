package com.example.Practica.persistence.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100, message = "El nombre de un producto, no puede tener más de 100 caracteres")
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Size(max = 255, message = "La descripción de un producto, no puede tener más de 255 caracteres")
    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;

    @PositiveOrZero(message = "El precio de un producto, debe ser un valor positivo o cero")
    @NotBlank(message = "El precio es obligatorio")
    private double precio;

    private LocalDateTime created_at;
    
    private LocalDateTime updated_at;

    @PrePersist
    protected void onCreate() {
        this.created_at = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_at = LocalDateTime.now();
    }

}
