package com.example.buensaborback.controller;

import com.example.buensaborback.domain.entities.ArticuloInsumo;
import com.example.buensaborback.domain.entities.Empresa;
import com.example.buensaborback.domain.entities.dto.ArticuloInsumoDto;
import com.example.buensaborback.services.ArticuloInsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insumo")
@CrossOrigin("*")
public class ArticuloInsumoController {

    @Autowired
    private ArticuloInsumoService articuloInsumoService;

    @GetMapping("/all")
    public ResponseEntity<List<ArticuloInsumo>> getAll() {
        return ResponseEntity.ok().body(articuloInsumoService.getAll());
    }

    @GetMapping("/{idInsumo}")
    public ResponseEntity<ArticuloInsumo> getById(@PathVariable Long idInsumo) {
        return ResponseEntity.ok(articuloInsumoService.getById(idInsumo));
    }

    @PostMapping("/create")
    public ResponseEntity<ArticuloInsumoDto> create(@RequestBody ArticuloInsumoDto dto) {
        return ResponseEntity.ok().body(articuloInsumoService.create(dto));
    }
}
