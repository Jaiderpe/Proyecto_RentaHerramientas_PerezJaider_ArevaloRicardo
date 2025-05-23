package com.herramientas.api.application.services;

import com.herramientas.api.persistence.entity.Rol;
import com.herramientas.api.persistence.repositories.RolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }
}