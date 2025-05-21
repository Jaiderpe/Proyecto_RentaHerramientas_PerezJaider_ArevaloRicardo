package com.herramientas.api.application.services;

import com.herramientas.api.persistence.entity.HerramientaCategoria;
import com.herramientas.api.persistence.repositories.HerramientaCategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HerramientaCategoriaService {

    @Autowired
    private HerramientaCategoriaRepository herramientaCategoriaRepository;

    public List<HerramientaCategoria> findAll() {
        return herramientaCategoriaRepository.findAll();
    }

    public HerramientaCategoria save(HerramientaCategoria herramientaCategoria) {
        return herramientaCategoriaRepository.save(herramientaCategoria);
    }
}