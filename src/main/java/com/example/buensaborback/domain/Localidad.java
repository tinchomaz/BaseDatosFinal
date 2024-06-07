package com.example.buensaborback.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Localidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLocalidad;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "FK_id_provincia")
    private Provincia provincia;

    @OneToMany(mappedBy = "localidad")
    private Set<Domicilio> domicilios;

    // Getters and Setters
}