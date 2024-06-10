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
public class HistorialEmpleadoSucursal extends Base{

    private LocalDate fecha;

    @JoinColumn(name = "fk_id_rol")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "fk_id_empleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "fk_id_sucursal")
    private Sucursal sucursal;

    // Getters and Setters
}

