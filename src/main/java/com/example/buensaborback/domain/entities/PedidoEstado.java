package com.example.buensaborback.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class PedidoEstado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido_estado;

    private LocalDateTime fecha_hora;

    @ManyToOne
    @JoinColumn(name = "FK_id_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "FK_id_estado")
    private Estado estado;

    // Getters and Setters
}

