package com.example.Practica.persistence.entity.user.permissions;

import com.example.Practica.persistence.entity.audit.AuditEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "permissions")
public class PermissionEntity extends AuditEntity {

    private PermissionEnum permission;
    private String description;
}
