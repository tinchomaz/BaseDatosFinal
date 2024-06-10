package com.example.buensaborback.domain;

import jakarta.persistence.*;

@Entity
public class SubCategoria{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_subcategoria;

    @ManyToOne
    @JoinColumn(name = "FK_categoria_padre")
    private Categoria categoriaPadre;

    @ManyToOne
    @JoinColumn(name = "FK_categoria_hija")
    private Categoria categoriaHija;

    // Getters and Setters
}
