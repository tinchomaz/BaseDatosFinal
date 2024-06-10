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
public class SucursalInsumo extends Base{

    private Integer stock_minimo;
    private Integer stock_maximo;

    @Builder.Default
    private boolean habilitado = true;

    @ManyToOne
    @JoinColumn(name = "FK_id_sucursal")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "FK_id_insumo")
    private ArticuloInsumo insumo;

    // Getters and Setters
}