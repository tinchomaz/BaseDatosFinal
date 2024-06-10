package com.example.buensaborback.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
public class Pedido extends Base{

    private LocalDateTime hora_estimada_finalizacion;
    private LocalDate fecha_pedido;

    @ManyToOne
    @JoinColumn(name = "FK_id_cliente_domicilio")
    private ClienteDomicilio clienteDomicilio;

    @ManyToOne
    @JoinColumn(name = "FK_id_sucursal")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "FK_id_empleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "FK_id_FormaPago")
    private FormaPago formaPago;

    @ManyToOne
    @JoinColumn(name = "FK_id_TipoEnvio")
    private TipoEnvio tipoEnvio;
}

