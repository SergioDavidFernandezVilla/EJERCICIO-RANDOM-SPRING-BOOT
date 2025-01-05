package com.example.Practica.persistence.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
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
@Table(name = "image")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String fileName;
    private String filePath;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    

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
