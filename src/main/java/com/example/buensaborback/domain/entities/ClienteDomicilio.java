package com.example.buensaborback.domain;

import jakarta.persistence.*;

@Entity
public class ClienteDomicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente_domicilio;

    @ManyToOne
    @JoinColumn(name = "FK_id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "FK_id_domicilio")
    private Domicilio domicilio;

    // Getters and Setters
}

