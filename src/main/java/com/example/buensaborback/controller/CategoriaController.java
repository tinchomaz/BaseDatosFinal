package com.example.buensaborback.controller;

import com.example.buensaborback.domain.entities.Categoria;
import com.example.buensaborback.domain.entities.Empresa;
import com.example.buensaborback.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;
    @GetMapping("")
    public ResponseEntity<List<Categoria>> getAll() {
        return ResponseEntity.ok().body(categoriaService.getAll());
    }


}
