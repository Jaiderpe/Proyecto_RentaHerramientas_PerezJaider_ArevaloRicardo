package com.herramientas.api.infrastructure.controllers;

import com.herramientas.api.application.services.ImagenHerramientaService;
import com.herramientas.api.domain.dtos.ImagenHerramientaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/imagenes-herramienta")
public class ImagenHerramientaController {

    @Autowired
    private ImagenHerramientaService service;

    @GetMapping
    public ResponseEntity<List<ImagenHerramientaDTO>> getAll() {
        return ResponseEntity.ok(service.getAllImagenes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImagenHerramientaDTO> getById(@PathVariable Integer id) {
        ImagenHerramientaDTO dto = service.getImagenById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ImagenHerramientaDTO> create(@RequestBody ImagenHerramientaDTO dto) {
        ImagenHerramientaDTO saved = service.saveImagen(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getIdImagen())
                .toUri();
        return ResponseEntity.created(location).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImagenHerramientaDTO> update(@PathVariable Integer id, @RequestBody ImagenHerramientaDTO dto) {
        if (!dto.getIdImagen().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(service.updateImagen(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (service.getImagenById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteImagen(id);
        return ResponseEntity.noContent().build();
    }
}