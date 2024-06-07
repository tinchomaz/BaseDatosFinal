package com.example.buensaborback.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class HistorialPrecioManufacturado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_hist_precio_insumo;

    private Float precio_costo;
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "FK_id_sucursal_manufacturado")
    private SucursalManufacturado sucursalManufacturado;

    // Getters and Setters
}

