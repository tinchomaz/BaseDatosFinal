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
public class HistorialPrecioInsumo extends Base{

    private Float precio_compra;
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "FK_id_sucursal_insumo")
    private SucursalInsumo sucursalInsumo;

    // Getters and Setters
}

