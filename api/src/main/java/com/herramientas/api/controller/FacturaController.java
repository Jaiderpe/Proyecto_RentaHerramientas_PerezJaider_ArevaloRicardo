package com.herramientas.api.controller;

import com.herramientas.api.application.services.FacturaService;
import com.herramientas.api.persistence.entity.Factura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public List<Factura> getAllFacturas() {
        return facturaService.findAll();
    }

    @PostMapping
    public Factura createFactura(@RequestBody Factura factura) {
        return facturaService.save(factura);
    }
}