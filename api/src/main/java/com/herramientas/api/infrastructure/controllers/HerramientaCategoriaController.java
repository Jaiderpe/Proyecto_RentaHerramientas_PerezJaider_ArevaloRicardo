package com.herramientas.api.infrastructure.controllers;

import com.herramientas.api.application.services.HerramientaCategoriaService;
import com.herramientas.api.domain.entities.HerramientaCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/herramienta-categoria")
public class HerramientaCategoriaController {

    @Autowired
    private HerramientaCategoriaService herramientaCategoriaService;

    @GetMapping
    public List<HerramientaCategoria> getAllHerramientaCategorias() {
        return herramientaCategoriaService.findAll();
    }

    @PostMapping
    public HerramientaCategoria createHerramientaCategoria(@RequestBody HerramientaCategoria herramientaCategoria) {
        return herramientaCategoriaService.save(herramientaCategoria);
    }
}