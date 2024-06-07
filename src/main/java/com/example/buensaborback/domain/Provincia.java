package com.example.buensaborback.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProvincia;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "FK_id_pais")
    private Pais pais;

    @OneToMany(mappedBy = "provincia")
    private Set<Localidad> localidades;

    // Getters and Setters
}
