package com.herramientas.api.infrastructure.controllers;

import com.herramientas.api.application.services.PagoService;
import com.herramientas.api.domain.entities.Pago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping
    public List<Pago> getAllPagos() {
        return pagoService.findAll();
    }

    @PostMapping
    public Pago createPago(@RequestBody Pago pago) {
        return pagoService.save(pago);
    }
}