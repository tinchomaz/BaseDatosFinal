package com.example.buensaborback.domain;

import jakarta.persistence.*;

@Entity
public class DetallePromocionArticulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_detalle_promocion;

    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "FK_id_articulo")
    private Articulo articulo;

    @ManyToOne
    @JoinColumn(name = "FK_id_promocion")
    private Promocion promocion;

    // Getters and Setters
}

