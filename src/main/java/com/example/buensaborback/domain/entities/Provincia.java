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
public class Provincia extends Base{

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "FK_id_pais")
    private Pais pais;

    @OneToMany(mappedBy = "provincia")
    @Builder.Default
    @JsonIgnore
    private Set<Localidad> localidades = new HashSet<>();

    // Getters and Setters
}
