package com.example.Practica.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "marca")
public class MarcaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50, message = "La nombre de la marca no puede tener más de 50 caracteres")
    @NotBlank(message = "La marca es obligatoria")
    @Column(unique = true)
    private String marca;

    @Size(max = 255, message = "La descripción de una marca, no puede tener más de 255 caracteres")
    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;


    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "marca")  // Asegúrate de que la propiedad en ProductoEntity se llame 'marca'
    private List<ProductEntity> productos;

    @PrePersist
    public void prePersist() {
        if (created_at == null) {
            created_at = LocalDateTime.now();  // Se establece solo una vez en la creación.
        }
        if (updated_at == null) {
            updated_at = LocalDateTime.now();  // Se establece en la creación también.
        }
    }
}
