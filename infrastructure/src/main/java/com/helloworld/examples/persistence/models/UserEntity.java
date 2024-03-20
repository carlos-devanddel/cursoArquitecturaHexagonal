package com.helloworld.examples.persistence.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "USUARIO")
public class UserEntity {
    @Id
    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String mail;
}
