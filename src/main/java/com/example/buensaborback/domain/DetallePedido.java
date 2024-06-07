package com.example.buensaborback.domain;

import jakarta.persistence.*;

@Entity
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_detalle_pedido;

    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "FK_id_articulo")
    private Articulo articulo;

    @ManyToOne
    @JoinColumn(name = "FK_id_pedido")
    private Pedido pedido;

    // Getters and Setters
}