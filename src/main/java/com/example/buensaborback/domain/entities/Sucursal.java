package com.example.buensaborback.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
public class Sucursal extends Base{

    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private Boolean esCasaMatriz;

    @ManyToOne
    @JoinColumn(name = "FK_id_domicilio")
    private Domicilio domicilio;

    @ManyToOne
    @JoinColumn(name = "FK_id_empresa")
    private Empresa empresa;

    @OneToMany
    @Builder.Default
    @JoinColumn(name = "id_sucursal")
    private Set<ImagenSucursal> imagenesSucursal = new HashSet<ImagenSucursal>();
}