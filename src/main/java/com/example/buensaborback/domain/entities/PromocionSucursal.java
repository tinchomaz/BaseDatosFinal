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
public class PromocionSucursal extends Base{

    private Boolean habilitado;
    private LocalDate fecha_desde;
    private LocalDate fecha_hasta;
    private String hora_desde;
    private String hora_hasta;

    @ManyToOne
    @JoinColumn(name = "FK_id_sucursal")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "FK_id_Promocion")
    private Promocion promocion;

    // Getters and Setters
}

