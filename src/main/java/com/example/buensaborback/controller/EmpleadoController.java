package com.example.buensaborback.controller;

import com.example.buensaborback.domain.entities.Empleado;
import com.example.buensaborback.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")
@CrossOrigin("*")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/all")
    public ResponseEntity<List<Empleado>> getAll() {
        return ResponseEntity.ok().body(empleadoService.getAll());
    }
    @GetMapping("/{idEmpleado}")
    public ResponseEntity<Empleado> getById(@PathVariable Long idEmpleado) {
        return ResponseEntity.ok(empleadoService.getById(idEmpleado));
    }
}
