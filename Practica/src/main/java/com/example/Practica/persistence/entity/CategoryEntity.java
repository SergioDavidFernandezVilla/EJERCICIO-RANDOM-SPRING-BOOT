package com.example.Practica.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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
@Table(name = "categoria")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50, message = "La categoria no puede tener más de 50 caracteres")
    @NotBlank(message = "La categoria es obligatoria")
    private String categoria;

    @Size(max = 50, message = "La descripcion de la categoria no puede tener más de 50 caracteres")
    @NotBlank(message = "La marca es obligatoria")
    private String descripcion;

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
