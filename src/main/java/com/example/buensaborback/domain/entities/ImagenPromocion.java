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
public class ImagenPromocion extends Base{

    private String nombre;
    private String url;

    @ManyToOne
    @JoinColumn(name = "FK_id_promocion")
    private Promocion promocion;

    @OneToMany
    @Builder.Default
    @JoinColumn(name = "id_promocion")
    private Set<ImagenPromocion> imagenPromocion = new HashSet<ImagenPromocion>();
}

