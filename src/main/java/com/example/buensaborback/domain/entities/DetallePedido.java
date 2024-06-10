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
public class DetallePedido extends Base{

    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "FK_id_articulo")
    private Articulo articulo;

    @ManyToOne
    @JoinColumn(name = "FK_id_pedido")
    private Pedido pedido;

    // Getters and Setters
}