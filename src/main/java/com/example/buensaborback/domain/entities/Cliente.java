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
public class Cliente extends Base{

    private String nombre;
    private String apellido;
    private LocalDate fecha_nac;

    @ManyToOne
    @JoinColumn(name = "FK_id_usuario")
    private Usuario usuario;

    // Getters and Setters
}

