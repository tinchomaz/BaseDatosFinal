package com.example.buensaborback.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_empleado;

    private String nombre;
    private String apellido;
    private LocalDate fecha_nac;

    @ManyToOne
    @JoinColumn(name = "FK_id_usuario")
    private Usuario usuario;

    // Getters and Setters
}
