package com.example.buensaborback.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
public class Articulo extends Base{

    private String denominacion;
    private String codigo;
    private double costo;

    @ManyToOne
    @JoinColumn(name = "FK_id_categoria")
    private Categoria categoria;

    @OneToMany
    @Builder.Default
    @JoinColumn(name = "id_articulo")
    private Set<ImagenArticulo> imagenArticulo = new HashSet<ImagenArticulo>();
}
