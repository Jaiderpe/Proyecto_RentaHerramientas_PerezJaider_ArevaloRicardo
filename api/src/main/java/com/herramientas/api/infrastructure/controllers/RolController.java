package com.herramientas.api.infrastructure.controllers;

import com.herramientas.api.application.services.RolService;
import com.herramientas.api.domain.dtos.RolDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService service;

    @GetMapping
    public ResponseEntity<List<RolDTO>> getAll() {
        return ResponseEntity.ok(service.getAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> getById(@PathVariable Integer id) {
        RolDTO dto = service.getRolById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<RolDTO> create(@RequestBody RolDTO dto) {
        RolDTO saved = service.saveRol(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getIdRol())
                .toUri();
        return ResponseEntity.created(location).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> update(@PathVariable Integer id, @RequestBody RolDTO dto) {
        if (!dto.getIdRol().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(service.updateRol(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (service.getRolById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteRol(id);
        return ResponseEntity.noContent().build();
    }
}