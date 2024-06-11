package com.example.buensaborback.domain.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ArticuloInsumoDto {
    private String denominacion;
    private String codigo;
    private boolean es_para_elaborar;
}
