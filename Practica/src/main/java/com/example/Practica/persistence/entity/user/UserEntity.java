package com.example.Practica.persistence.entity.user;

import com.example.Practica.persistence.entity.audit.AuditEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    
    private String email;
    private String password;
    private String name;
    private String lastName;
    private String birthDate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permissions_id")
    private String permissions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roles_id")
    private String roles;
}
