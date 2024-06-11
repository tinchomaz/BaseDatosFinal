package com.example.buensaborback.controller;

import com.example.buensaborback.domain.entities.ArticuloInsumo;
import com.example.buensaborback.domain.entities.ArticuloManufacturado;
import com.example.buensaborback.services.ArticuloManufacturadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manufacturado")
@CrossOrigin("*")
public class ArticuloManufacturadoController {

    @Autowired
    private ArticuloManufacturadoService articuloManufacturadoService;

    @GetMapping("/all")
    public ResponseEntity<List<ArticuloManufacturado>> getAll() {
        return ResponseEntity.ok().body(articuloManufacturadoService.getAll());
    }

    @GetMapping("/{idManufacturado}")
    public ResponseEntity<ArticuloManufacturado> getById(@PathVariable Long idManufacturado) {
        return ResponseEntity.ok(articuloManufacturadoService.getById(idManufacturado));
    }
}
