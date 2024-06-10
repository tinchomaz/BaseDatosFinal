package com.example.buensaborback.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
public class PedidoEstado extends Base{

    private LocalDateTime fecha_hora;

    @ManyToOne
    @JoinColumn(name = "fk_id_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name ="fk_id_estado")
    private Estado estado;
}

