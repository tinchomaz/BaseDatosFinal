package com.example.buensaborback.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPais;

    private String nombre;

    @OneToMany(mappedBy = "pais")
    private Set<Provincia> provincias;

    // Getters and Setters
}