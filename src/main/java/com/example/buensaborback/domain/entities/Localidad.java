package com.example.buensaborback.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Localidad extends Base{

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "FK_id_provincia")
    private Provincia provincia;

    @OneToMany(mappedBy = "localidad")
    @Builder.Default
    @JsonIgnore
    private Set<Domicilio> domicilios = new HashSet<>();
}