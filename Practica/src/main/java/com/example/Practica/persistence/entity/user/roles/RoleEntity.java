package com.example.Practica.persistence.entity.user.roles;

import com.example.Practica.persistence.entity.audit.AuditEntity;
import com.example.Practica.persistence.entity.user.permissions.PermissionEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class RoleEntity extends AuditEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private RoleEnum roles;
    private String description;
}
