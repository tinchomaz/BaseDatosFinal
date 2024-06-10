package com.example.buensaborback.domain;


import jakarta.persistence.*;

@Entity
public class ImagenSucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idImagenSucursal;

    private String nombre;
    private String url;

    @ManyToOne
    @JoinColumn(name = "FK_id_sucursal")
    private Sucursal sucursal;

    // Getters and Setters
}

