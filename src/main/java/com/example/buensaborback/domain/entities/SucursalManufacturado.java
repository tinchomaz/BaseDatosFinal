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
public class SucursalManufacturado extends Base{

    @Builder.Default
    private boolean habilitado = true;

    @ManyToOne
    @JoinColumn(name = "FK_id_manufacturado")
    private ArticuloManufacturado manufacturado;

    @ManyToOne
    @JoinColumn(name = "FK_id_sucursal")
    private Sucursal sucursal;

    // Getters and Setters
}

