package com.example.buensaborback.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class PromocionSucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_promocion_sucursal;

    private Boolean habilitado;
    private LocalDate fecha_desde;
    private LocalDate fecha_hasta;
    private String hora_desde;
    private String hora_hasta;

    @ManyToOne
    @JoinColumn(name = "FK_id_sucursal")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "FK_id_Promocion")
    private Promocion promocion;

    // Getters and Setters
}

