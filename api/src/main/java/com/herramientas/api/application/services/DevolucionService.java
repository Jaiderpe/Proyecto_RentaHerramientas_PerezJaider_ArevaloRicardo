package com.herramientas.api.application.services;

import com.herramientas.api.domain.entities.Devolucion;
import com.herramientas.api.infrastructure.repositories.DevolucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevolucionService {

    @Autowired
    private DevolucionRepository devolucionRepository;

    public List<Devolucion> findAll() {
        return devolucionRepository.findAll();
    }

    public Devolucion save(Devolucion devolucion) {
        return devolucionRepository.save(devolucion);
    }
}