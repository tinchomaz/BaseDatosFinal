package com.example.buensaborback.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
public class SubCategoria extends Base{

    @ManyToOne
    @JoinColumn(name = "FK_categoria_padre")
    private Categoria categoriaPadre;

    @ManyToOne
    @JoinColumn(name = "FK_categoria_hija")
    private Categoria categoriaHija;

    // Getters and Setters
}
