package com.example.buensaborback.domain.dto;

import com.example.buensaborback.domain.entities.Domicilio;
import com.example.buensaborback.domain.entities.Empresa;
import com.example.buensaborback.domain.entities.ImagenSucursal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SucursalDto extends BaseDto {
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private Boolean esCasaMatriz;


    private Domicilio domicilio;


    private EmpresaDto empresa;


    private Set<ImagenSucursal> imagenesSucursal = new HashSet<ImagenSucursal>();
}
