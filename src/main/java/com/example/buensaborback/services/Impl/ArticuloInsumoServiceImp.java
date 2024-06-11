package com.example.buensaborback.services.Impl;

import com.example.buensaborback.domain.entities.ArticuloInsumo;
import com.example.buensaborback.domain.dto.ArticuloInsumoDto;
import com.example.buensaborback.repositories.ArticuloInsumoRepository;
import com.example.buensaborback.services.ArticuloInsumoService;
import com.example.buensaborback.services.Base.BaseServiceImp;
import org.springframework.stereotype.Service;

@Service
public class ArticuloInsumoServiceImp extends BaseServiceImp<ArticuloInsumo, Long> implements ArticuloInsumoService {
    private ArticuloInsumoRepository articuloInsumoRepository;
    @Override
    public void create(ArticuloInsumoDto articuloInsumoDto) {
        ArticuloInsumo articuloInsumo = new ArticuloInsumo();
        articuloInsumo.setDenominacion(articuloInsumoDto.getDenominacion());
        articuloInsumo.setCodigo(articuloInsumoDto.getCodigo());
        articuloInsumo.setEs_para_elaborar(articuloInsumoDto.isEs_para_elaborar());
        articuloInsumoRepository.save(articuloInsumo);
    }
}
