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
public class TelefonoCliente extends Base{
    private int numero;

    @ManyToOne
    @JoinColumn(name = "FK_id_cliente")
    private Cliente cliente;

    // Getters and Setters
}

