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
public class Usuario extends Base{
    private String auth0id;
    private String username;
    private String email;

    private Rol rol;

    // Getters and Setters
}

