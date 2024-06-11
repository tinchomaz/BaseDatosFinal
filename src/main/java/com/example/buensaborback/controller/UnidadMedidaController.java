package com.example.buensaborback.controller;

import com.example.buensaborback.domain.entities.Categoria;
import com.example.buensaborback.domain.entities.UnidadMedida;
import com.example.buensaborback.services.UnidadMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/unidadMedida")
@CrossOrigin("*")
public class UnidadMedidaController {
    @Autowired
    private UnidadMedidaService unidadMedidaService;

    @GetMapping("")
    public ResponseEntity<List<UnidadMedida>> getAll() {
        return ResponseEntity.ok().body(unidadMedidaService.getAll());
    }

}
