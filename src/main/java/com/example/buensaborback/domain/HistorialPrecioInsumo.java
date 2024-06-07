package com.example.buensaborback.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class HistorialPrecioInsumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_hist_precio_insumo;

    private Float precio_compra;
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "FK_id_sucursal_insumo")
    private SucursalInsumo sucursalInsumo;

    // Getters and Setters
}

