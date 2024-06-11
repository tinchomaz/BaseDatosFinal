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
public class ArticuloInsumo extends Articulo{

    private Boolean es_para_elaborar;

    @ManyToOne
    @JoinColumn(name = "FK_id_unidad_medida")
    private UnidadMedida unidadMedida;

}

