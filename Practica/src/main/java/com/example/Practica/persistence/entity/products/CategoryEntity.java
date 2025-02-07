package com.example.Practica.persistence.entity.products;

import java.util.Set;

import com.example.Practica.persistence.entity.audit.AuditEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "categoria")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50, message = "La categoria no puede tener más de 50 caracteres")
    @NotBlank(message = "La categoria es obligatoria")
    @Column(unique = true)
    private String nombre;

    @Size(max = 50, message = "La descripción de la categoría no puede tener más de 50 caracteres")
    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<ProductEntity> productos; // Relación inversa con "ProductEntity"

}