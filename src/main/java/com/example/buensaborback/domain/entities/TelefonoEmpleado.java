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
public class TelefonoEmpleado extends Base{

    private int numero;

    @ManyToOne
    @JoinColumn(name = "FK_id_empleado")
    private Empleado empleado;

    // Getters and Setters
}

