package com.example.buensaborback.controller;

import com.example.buensaborback.domain.entities.Empresa;
import com.example.buensaborback.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
@CrossOrigin("*")
public class EmpresaController{
    @Autowired
    private EmpresaService empresaService;

    @GetMapping("")
    public ResponseEntity<List<Empresa>> getAll() {
        return ResponseEntity.ok().body(empresaService.getAll());
    }


    @GetMapping("/{idEmpresa}")
    public ResponseEntity<Empresa> getById(@PathVariable Long idEmpresa) {
        return ResponseEntity.ok(empresaService.getById(idEmpresa));
    }
}
