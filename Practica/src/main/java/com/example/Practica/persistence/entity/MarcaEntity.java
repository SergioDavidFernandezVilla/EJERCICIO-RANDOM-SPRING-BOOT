package com.example.Practica.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "marcas")
public class MarcaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50, message = "La nombre de la marca no puede tener más de 50 caracteres")
    @NotBlank(message = "La marca es obligatoria")
    private String nombre;

    @Size(max = 255, message = "La descripción de una marca, no puede tener más de 255 caracteres")
    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;
}
