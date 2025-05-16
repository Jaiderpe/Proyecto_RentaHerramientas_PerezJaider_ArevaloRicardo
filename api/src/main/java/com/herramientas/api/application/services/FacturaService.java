package com.herramientas.api.application.services;

import com.herramientas.api.domain.entities.Factura;
import com.herramientas.api.infrastructure.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public List<Factura> findAll() {
        return facturaRepository.findAll();
    }

    public Factura save(Factura factura) {
        return facturaRepository.save(factura);
    }
}