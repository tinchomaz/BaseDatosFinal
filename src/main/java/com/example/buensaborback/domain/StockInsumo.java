package com.example.buensaborback.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class StockInsumo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_stock_insumo;

    private Integer cantidad;
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "FK_sucursal_insumo")
    private SucursalInsumo sucursalInsumo;

    // Getters and Setters
}

