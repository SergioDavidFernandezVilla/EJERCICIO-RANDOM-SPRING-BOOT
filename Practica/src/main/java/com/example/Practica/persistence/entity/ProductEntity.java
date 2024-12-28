package com.example.Practica.persistence.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @Column(name = "fecha_creada")
    private LocalDateTime created_at;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private MarcaEntity marca;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoryEntity categoria;
}
