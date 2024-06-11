package com.example.buensaborback.domain.dto;

import com.example.buensaborback.domain.entities.Categoria;
import com.example.buensaborback.domain.entities.ImagenArticulo;
import com.example.buensaborback.domain.entities.UnidadMedida;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ArticuloInsumoDto extends BaseDto{
    private String denominacion;
    private String codigo;
    private Long idCategoria;
    private Float precio_compra;
    private LocalDate fecha_compra;
    private Integer stock_minimo;
    private Integer stock_maximo;
    private Integer stock_actual;
    private boolean es_para_elaborar;
    private Long idUnidadMedida;
    private Long idSucursal;
    private Set<ImagenArticulo> imagenArticulo ;
}
