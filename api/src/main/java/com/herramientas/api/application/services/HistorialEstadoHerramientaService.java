package com.herramientas.api.application.services;

import com.herramientas.api.domain.entities.HistorialEstadoHerramienta;
import com.herramientas.api.infrastructure.repositories.HistorialEstadoHerramientaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialEstadoHerramientaService {

    @Autowired
    private HistorialEstadoHerramientaRepository historialEstadoHerramientaRepository;

    public List<HistorialEstadoHerramienta> findAll() {
        return historialEstadoHerramientaRepository.findAll();
    }

    public HistorialEstadoHerramienta save(HistorialEstadoHerramienta historial) {
        return historialEstadoHerramientaRepository.save(historial);
    }
}