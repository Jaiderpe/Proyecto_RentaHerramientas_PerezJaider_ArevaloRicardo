package com.herramientas.api.application.services;

import com.herramientas.api.persistence.entity.Notificacion;
import com.herramientas.api.persistence.repositories.NotificacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    public List<Notificacion> findAll() {
        return notificacionRepository.findAll();
    }

    public Notificacion save(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }
}