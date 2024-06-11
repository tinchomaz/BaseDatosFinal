package com.example.buensaborback.services;

import com.example.buensaborback.domain.entities.ArticuloInsumo;
import com.example.buensaborback.domain.entities.dto.ArticuloInsumoDto;
import com.example.buensaborback.services.Base.BaseService;

public interface ArticuloInsumoService extends BaseService<ArticuloInsumo, Long> {
    public void create(ArticuloInsumoDto articuloInsumoDto);
}
