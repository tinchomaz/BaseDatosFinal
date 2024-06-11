package com.example.buensaborback.domain.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
public class Domicilio extends Base{

    private String calle;
    private int numero;
    private int cp;
    private Integer piso;
    private String nroDepto;

    @ManyToOne
    @JoinColumn(name = "FK_id_localidad")
    private Localidad localidad;

    @OneToMany(mappedBy = "domicilio")
    @JsonIgnore
    private Set<Sucursal> sucursales;

    // Getters and Setters
}
