package com.example.buensaborback.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
public class Empresa extends Base{

    private String nombre;
    private String cuit;

    @OneToMany
    @Builder.Default
    private Set<ImagenEmpresa> imagenes = new HashSet<>();

    @OneToMany(mappedBy = "empresa")
    @Builder.Default
    private Set<Sucursal> sucursales = new HashSet<>();

    @OneToMany
    @Builder.Default
    @JoinColumn(name = "id_empresa")
    private Set<ImagenEmpresa> imagenEmpresas = new HashSet<ImagenEmpresa>();
}
