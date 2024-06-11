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
public class Promocion extends Base{

    private String denominacion;
    private String descripcion_descuento;

    @OneToMany
    @Builder.Default
    @JoinColumn(name = "id_promocion")
    private Set<ImagenPromocion> imagenPromocion = new HashSet<ImagenPromocion>();
}

