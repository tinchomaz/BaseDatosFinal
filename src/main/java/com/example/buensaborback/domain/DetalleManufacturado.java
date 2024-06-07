package com.example.buensaborback.domain;

import jakarta.persistence.*;

@Entity
public class DetalleManufacturado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_detalle_Manufacturado;

    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "FK_id_insumo")
    private ArticuloInsumo insumo;

    @ManyToOne
    @JoinColumn(name = "FK_id_manufacturado")
    private ArticuloManufacturado manufacturado;

    // Getters and Setters
}

