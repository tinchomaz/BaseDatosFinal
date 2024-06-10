package com.example.buensaborback.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Empresa{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpresa;

    private String nombre;
    private String cuit;

    @OneToMany(mappedBy = "empresa")
    private Set<ImagenEmpresa> imagenes;

    @OneToMany(mappedBy = "empresa")
    private Set<Sucursal> sucursales;

    // Getters and Setters
}
