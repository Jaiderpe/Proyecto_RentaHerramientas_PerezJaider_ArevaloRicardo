package com.herramientas.api.infrastructure.controllers;

import com.herramientas.api.application.services.HerramientaService;
import com.herramientas.api.domain.dtos.HerramientaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/herramientas")
public class HerramientaController {

    @Autowired
    private HerramientaService service;

    @GetMapping
    public ResponseEntity<List<HerramientaDTO>> getAll() {
        return ResponseEntity.ok(service.getAllHerramientas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HerramientaDTO> getById(@PathVariable Integer id) {
        HerramientaDTO dto = service.getHerramientaById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<HerramientaDTO> create(@RequestBody HerramientaDTO dto) {
        HerramientaDTO saved = service.saveHerramienta(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getIdHerramienta())
                .toUri();
        return ResponseEntity.created(location).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HerramientaDTO> update(@PathVariable Integer id, @RequestBody HerramientaDTO dto) {
        if (!dto.getIdHerramienta().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(service.updateHerramienta(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (service.getHerramientaById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteHerramienta(id);
        return ResponseEntity.noContent().build();
    }
}