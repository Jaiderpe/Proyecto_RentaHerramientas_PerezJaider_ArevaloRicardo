package com.herramientas.api.application.services;

import com.herramientas.api.persistence.entity.HistorialEstadoHerramienta;
import com.herramientas.api.persistence.repositories.HistorialEstadoHerramientaRepository;

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