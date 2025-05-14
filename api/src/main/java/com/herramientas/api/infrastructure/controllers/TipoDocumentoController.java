package com.herramientas.api.infrastructure.controllers;

import com.herramientas.api.application.services.TipoDocumentoService;
import com.herramientas.api.domain.dtos.TipoDocumentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-documento")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoService service;

    @GetMapping
    public ResponseEntity<List<TipoDocumentoDTO>> getAll() {
        return ResponseEntity.ok(service.getAllTiposDocumento());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDocumentoDTO> getById(@PathVariable Integer id) {
        TipoDocumentoDTO dto = service.getTipoDocumentoById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TipoDocumentoDTO> create(@RequestBody TipoDocumentoDTO dto) {
        TipoDocumentoDTO saved = service.saveTipoDocumento(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getIdTipoDocumento())
                .toUri();
        return ResponseEntity.created(location).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDocumentoDTO> update(@PathVariable Integer id, @RequestBody TipoDocumentoDTO dto) {
        if (!dto.getIdTipoDocumento().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(service.saveTipoDocumento(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (service.getTipoDocumentoById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteTipoDocumento(id);
        return ResponseEntity.noContent().build();
    }
}