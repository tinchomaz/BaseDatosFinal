package com.example.buensaborback.domain;

import jakarta.persistence.*;


@Entity
public class ImagenEmpresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idImagenEmpresa;

    private String nombre;
    private String url;

    @ManyToOne
    @JoinColumn(name = "FK_id_empresa")
    private Empresa empresa;

    // Getters and Setters
}
