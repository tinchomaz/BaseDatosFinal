package com.example.buensaborback.domain;

import jakarta.persistence.*;

@Entity
public class TelefonoEmpleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_telefono_empleado;

    private String numero;

    @ManyToOne
    @JoinColumn(name = "FK_id_empleado")
    private Empleado empleado;

    // Getters and Setters
}

