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
public class ImagenSucursal extends Base{

    private String nombre;
    private String url;

}

