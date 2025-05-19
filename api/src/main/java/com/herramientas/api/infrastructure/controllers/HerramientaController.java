package com.herramientas.api.infrastructure.controllers;

import com.herramientas.api.application.services.HerramientaService;
import com.herramientas.api.domain.entities.Herramienta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/herramientas")
public class HerramientaController {

    @Autowired
    private HerramientaService herramientaService;

    @GetMapping
    public List<Herramienta> getAllHerramientas() {
        return herramientaService.findAll();
    }

    @PostMapping
    public Herramienta createHerramienta(@RequestBody Herramienta herramienta) {
        return herramientaService.save(herramienta);
    }

    @DeleteMapping("/{id}")
    public void deleteHerramienta(@PathVariable Integer id) {
        herramientaService.deleteById(id);
    }
}