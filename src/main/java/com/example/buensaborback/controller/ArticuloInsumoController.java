package com.example.buensaborback.controller;

import com.example.buensaborback.domain.dto.ArticuloInsumoDto;
import com.example.buensaborback.domain.entities.ArticuloInsumo;
import com.example.buensaborback.domain.entities.HistorialPrecioInsumo;
import com.example.buensaborback.domain.entities.StockInsumo;
import com.example.buensaborback.domain.entities.SucursalInsumo;
import com.example.buensaborback.repositories.*;
import com.example.buensaborback.services.ArticuloInsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/insumo")
@CrossOrigin("*")
public class ArticuloInsumoController {

    @Autowired
    private ArticuloInsumoService articuloInsumoService;
    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;
    @Autowired
    private SucursalRepository sucursalRepository;
    @Autowired
    private SucursalInsumoRepository sucursalInsumoRepository;
    @Autowired
    private HistorialPrecioInsumoRepository historialPrecioInsumoRepository;
    @Autowired
    private StockInsumoRepository stockInsumoRepository;

    @GetMapping("/all")
    public ResponseEntity<List<ArticuloInsumo>> getAll() {
        return ResponseEntity.ok().body(articuloInsumoService.getAll());
    }

    @GetMapping("/{idInsumo}")
    public ResponseEntity<ArticuloInsumo> getById(@PathVariable Long idInsumo) {
        return ResponseEntity.ok(articuloInsumoService.getById(idInsumo));
    }

    @PostMapping("/create")
    public ResponseEntity<ArticuloInsumo> create(@RequestBody ArticuloInsumoDto dto) {
        ArticuloInsumo articuloInsumoNew = ArticuloInsumo.builder().denominacion(dto.getDenominacion()).
                codigo(dto.getCodigo()).categoria(categoriaRepository.getById(dto.getIdCategoria())).es_para_elaborar(dto.isEs_para_elaborar())
                .unidadMedida(unidadMedidaRepository.getById(dto.getIdUnidadMedida())).build();
        articuloInsumoNew.getImagenArticulo().addAll(dto.getImagenArticulo());
                articuloInsumoRepository.save(articuloInsumoNew);

        SucursalInsumo sucursalInsumo = SucursalInsumo.builder().sucursal(sucursalRepository.getById(dto.getIdSucursal())).insumo(articuloInsumoNew)
                .stock_maximo(dto.getStock_maximo()).stock_minimo(dto.getStock_minimo())
                .build();
        sucursalInsumoRepository.save(sucursalInsumo);
        HistorialPrecioInsumo historialPrecioInsumo = HistorialPrecioInsumo.builder().precio_compra(dto.getPrecio_compra()).fecha(dto.getFecha_compra())
                .sucursalInsumo(sucursalInsumo) .build();
        historialPrecioInsumoRepository.save(historialPrecioInsumo);
        StockInsumo stockInsumo = StockInsumo.builder().sucursalInsumo(sucursalInsumo).cantidad(dto.getStock_actual())
        .fecha(dto.getFecha_compra()).build();
        stockInsumoRepository.save(stockInsumo);

        return ResponseEntity.ok().body(articuloInsumoRepository.getById(articuloInsumoNew.getId()));
    }
}
