package com.example.Practica.persistence.entity.user;

import com.example.Practica.persistence.entity.audit.AuditEntity;
import com.example.Practica.persistence.entity.user.permissions.PermissionEntity;
import com.example.Practica.persistence.entity.user.roles.RoleEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "users")
public class UserEntity extends AuditEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String confirmPassword;
    private String name;
    private String lastName;
    private String birthDate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permissions_id")
    private PermissionEntity permissions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roles_id")
    private RoleEntity roles;
}
