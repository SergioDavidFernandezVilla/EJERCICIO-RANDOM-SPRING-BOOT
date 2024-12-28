package com.example.Practica.persistence.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100, message = "El nombre de la categoria no puede tener más de 100 caracteres")
    @NotBlank(message = "El nombre es obligatorio")
    private Set<String> nombre;

    @Size(max = 50, message = "La descripcion de la categoria no puede tener más de 50 caracteres")
    @NotBlank(message = "La marca es obligatoria")
    private String descripcion;
}
