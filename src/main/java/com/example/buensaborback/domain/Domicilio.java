package com.example.buensaborback.domain;


import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDomicilio;

    private String calle;
    private String numero;
    private String cp;
    private Integer piso;
    private String nroDepto;

    @ManyToOne
    @JoinColumn(name = "FK_id_localidad")
    private Localidad localidad;

    @OneToMany(mappedBy = "domicilio")
    private Set<Sucursal> sucursales;

    // Getters and Setters
}
