package com.example.Practica.persistence.entity.user;


import com.example.Practica.persistence.entity.audit.AuditEntity;
import com.example.Practica.persistence.entity.user.permissions.PermissionEntity;
import com.example.Practica.persistence.entity.user.roles.RoleEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserEntity extends AuditEntity {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    private String email;
    private String password;
    private String confirmPassword;
    private String username;
    private String lastName;
    private LocalDate birthDate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permissions_id")
    private PermissionEntity permissions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roles_id")
    private RoleEntity roles;
}
