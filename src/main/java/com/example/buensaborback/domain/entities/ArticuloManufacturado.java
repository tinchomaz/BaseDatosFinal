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
public class ArticuloManufacturado extends Articulo{

    private String descripcion;
    private String tiempo_estimado_preparacion;
    private String preparacion;

    @ManyToOne
    @JoinColumn(name = "FK_id_categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "FK_id_unidad_medida")
    private UnidadMedida unidadMedida;

}
