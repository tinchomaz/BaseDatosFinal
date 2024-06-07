package com.example.buensaborback.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;

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
    @JoinColumn(name = "FK_id_forma_pago")
    private FormaPago formaPago;

    @ManyToOne
    @JoinColumn(name = "FK_id_tipo_envio")
    private TipoEnvio tipoEnvio;

    // Getters and Setters
}

