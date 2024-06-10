package com.example.buensaborback.domain;

import jakarta.persistence.*;

@Entity
public class Articulo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_articulo;

    private String denominacion;
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "FK_id_categoria")
    private Categoria categoria;

    // Getters and Setters
}
