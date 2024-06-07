package com.example.buensaborback.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSucursal;

    private String nombre;
    private String horarioApertura;
    private String horarioCierre;
    private Boolean esCasaMatriz;

    @ManyToOne
    @JoinColumn(name = "FK_id_domicilio")
    private Domicilio domicilio;

    @ManyToOne
    @JoinColumn(name = "FK_id_empresa")
    private Empresa empresa;

    @OneToMany(mappedBy = "sucursal")
    private Set<ImagenSucursal> imagenes;

    // Getters and Setters
}