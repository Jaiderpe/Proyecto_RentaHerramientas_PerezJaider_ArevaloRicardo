package com.herramientas.api.controller;

import com.herramientas.api.application.services.TipoDocumentoService;
import com.herramientas.api.persistence.entity.TipoDocumento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-documento")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @GetMapping
    public List<TipoDocumento> getAllTiposDocumento() {
        return tipoDocumentoService.findAll();
    }

    @PostMapping
    public TipoDocumento createTipoDocumento(@RequestBody TipoDocumento tipoDocumento) {
        return tipoDocumentoService.save(tipoDocumento);
    }
}