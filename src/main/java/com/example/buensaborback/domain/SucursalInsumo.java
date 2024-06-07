package com.example.buensaborback.domain;

import jakarta.persistence.*;

@Entity
public class SucursalInsumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_sucursal_insumo;

    private Integer stock_minimo;
    private Integer stock_maximo;
    private Boolean habilitado;

    @ManyToOne
    @JoinColumn(name = "FK_id_sucursal")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "FK_id_insumo")
    private ArticuloInsumo insumo;

    // Getters and Setters
}