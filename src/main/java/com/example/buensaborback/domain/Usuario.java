package com.example.buensaborback.domain;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    private String auth0id;
    private String username;
    private String email;

    @ManyToOne
    @JoinColumn(name = "FK_id_rol")
    private Rol rol;

    // Getters and Setters
}

