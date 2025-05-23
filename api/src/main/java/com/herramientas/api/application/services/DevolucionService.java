package com.herramientas.api.application.services;

import com.herramientas.api.persistence.entity.Devolucion;
import com.herramientas.api.persistence.repositories.DevolucionRepository;

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