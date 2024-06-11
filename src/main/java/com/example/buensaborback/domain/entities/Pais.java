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
public class Pais extends Base{

    private String nombre;

    @OneToMany(mappedBy = "pais")
    @Builder.Default
    @JsonIgnore
    private Set<Provincia> provincias = new HashSet<>();

    // Getters and Setters
}