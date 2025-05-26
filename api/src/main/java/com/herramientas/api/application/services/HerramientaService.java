package com.herramientas.api.application.services;

import com.herramientas.api.persistence.entity.Herramienta;
import com.herramientas.api.persistence.entity.User;
import com.herramientas.api.persistence.repositories.HerramientaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HerramientaService {

    @Autowired
    private HerramientaRepository herramientaRepository;

    public List<Herramienta> findAll() {
        return herramientaRepository.findAll();
    }

    public Herramienta save(Herramienta herramienta) {
        return herramientaRepository.save(herramienta);
    }

    public void deleteById(Integer id) {
        herramientaRepository.deleteById(id);
    }

    public List<Herramienta> findByProveedor(User proveedor) {
        return herramientaRepository.findByProveedor(proveedor);
    }

    public List<Herramienta> findByCategoria(Integer idCategoria) {
        return herramientaRepository.findByCategorias_IdCategoria(idCategoria);
    }
}