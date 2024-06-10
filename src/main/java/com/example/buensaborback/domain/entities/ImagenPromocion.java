package com.example.buensaborback.domain;

import jakarta.persistence.*;

@Entity
public class ImagenPromocion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_imagen_promocion;

    private String nombre;
    private String url;

    @ManyToOne
    @JoinColumn(name = "FK_id_promocion")
    private Promocion promocion;

    // Getters and Setters
}

