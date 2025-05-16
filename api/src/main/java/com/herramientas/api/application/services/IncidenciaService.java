package com.herramientas.api.application.services;

import com.herramientas.api.domain.entities.Incidencia;
import com.herramientas.api.infrastructure.repositories.IncidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidenciaService {

    @Autowired
    private IncidenciaRepository incidenciaRepository;

    public List<Incidencia> findAll() {
        return incidenciaRepository.findAll();
    }

    public Incidencia save(Incidencia incidencia) {
        return incidenciaRepository.save(incidencia);
    }
}