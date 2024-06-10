package com.example.buensaborback.domain;

import jakarta.persistence.*;

@Entity
public class TelefonoCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_telefono_cliente;

    private String numero;

    @ManyToOne
    @JoinColumn(name = "FK_id_cliente")
    private Cliente cliente;

    // Getters and Setters
}

