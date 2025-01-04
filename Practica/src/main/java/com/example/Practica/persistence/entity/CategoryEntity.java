package com.example.Practica.persistence.entity;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

@Entity
@Table(name = "categoria")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50, message = "La categoría no puede tener más de 50 caracteres")
    @NotBlank(message = "La categoría es obligatoria")
    private String categoria;

    @Size(max = 50, message = "La descripción de la categoría no puede tener más de 50 caracteres")
    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private Set<ProductEntity> productos; // Relación inversa con "ProductEntity"

    

    @PrePersist
    public void prePersist() {
        if (created_at == null) {
            created_at = LocalDateTime.now();  // Se establece solo una vez en la creación.
        }
        if (updated_at == null) {
            updated_at = LocalDateTime.now();  // Se establece en la creación también.
        }
    }

    @PreUpdate
    public void preUpdate() {
        updated_at = LocalDateTime.now();  // Se actualiza solo el campo 'updated_at' al actualizar la entidad.
    }
}