package com.example.buensaborback.domain;

import jakarta.persistence.*;

@Entity
public class SucursalManufacturado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_sucursal_manufacturado;

    private Boolean habilitado;

    @ManyToOne
    @JoinColumn(name = "FK_id_manufacturado")
    private ArticuloManufacturado manufacturado;

    @ManyToOne
    @JoinColumn(name = "FK_id_sucursal")
    private Sucursal sucursal;

    // Getters and Setters
}

