package com.example.buensaborback.domain;

import jakarta.persistence.*;

@Entity
public class ArticuloInsumo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_insumo;

    private Boolean es_para_elaborar;

    @ManyToOne
    @JoinColumn(name = "FK_id_categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "FK_id_unidad_medida")
    private UnidadMedida unidadMedida;

    @ManyToOne
    @JoinColumn(name = "FK_id_articulo")
    private Articulo articulo;

    // Getters and Setters
}

