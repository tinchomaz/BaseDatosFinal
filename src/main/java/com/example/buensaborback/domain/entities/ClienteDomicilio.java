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
public class ClienteDomicilio extends Base{

    @ManyToOne
    @JoinColumn(name = "FK_id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "FK_id_domicilio")
    private Domicilio domicilio;

    // Getters and Setters
}

