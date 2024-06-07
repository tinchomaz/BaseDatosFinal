package com.example.buensaborback.domain;

import jakarta.persistence.*;

@Entity
public class ArticuloManufacturado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_manufacturado;

    private String descripcion;
    private String tiempo_estimado_preparacion;
    private String preparacion;

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
