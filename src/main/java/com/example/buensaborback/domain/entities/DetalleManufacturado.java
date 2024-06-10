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
public class DetalleManufacturado extends Base{

    @ManyToOne
    @JoinColumn(name = "FK_id_insumo")
    private ArticuloInsumo insumo;

    @ManyToOne
    @JoinColumn(name = "FK_id_manufacturado")
    private ArticuloManufacturado manufacturado;

    // Getters and Setters
}

