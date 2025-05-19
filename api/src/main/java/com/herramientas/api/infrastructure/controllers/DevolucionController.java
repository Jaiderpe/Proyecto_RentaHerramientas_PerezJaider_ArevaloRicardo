package com.herramientas.api.infrastructure.controllers;

import com.herramientas.api.application.services.DevolucionService;
import com.herramientas.api.domain.entities.Devolucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devoluciones")
public class DevolucionController {

    @Autowired
    private DevolucionService devolucionService;

    @GetMapping
    public List<Devolucion> getAllDevoluciones() {
        return devolucionService.findAll();
    }

    @PostMapping
    public Devolucion createDevolucion(@RequestBody Devolucion devolucion) {
        return devolucionService.save(devolucion);
    }
}