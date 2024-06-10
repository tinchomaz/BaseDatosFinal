package com.example.buensaborback.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class HistorialEmpleadoSucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_hist_empleado_sucursal;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "fk_id_rol")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "fk_id_empleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "fk_id_sucursal")
    private Sucursal sucursal;

    // Getters and Setters
}

