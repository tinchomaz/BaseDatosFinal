package com.example.buensaborback.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
public class HistorialPrecioManufacturado extends Base{

    private Float precio_costo;
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "FK_id_sucursal_manufacturado")
    private SucursalManufacturado sucursalManufacturado;

    // Getters and Setters
}

