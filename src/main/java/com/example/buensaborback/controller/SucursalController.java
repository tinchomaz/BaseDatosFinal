package com.example.buensaborback.controller;

import com.example.buensaborback.domain.entities.Sucursal;
import com.example.buensaborback.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sucursal")
@CrossOrigin("*")
public class SucursalController {
    @Autowired
    private SucursalService sucursalService;


    @GetMapping("/all")
    public ResponseEntity<List<Sucursal>> getAll() {
        return ResponseEntity.ok().body(sucursalService.getAll());
    }

    @GetMapping("/{idSucursal}")
    public ResponseEntity<Sucursal> getById(@PathVariable Long idSucursal) {
        return ResponseEntity.ok(sucursalService.getById(idSucursal));
    }
}
