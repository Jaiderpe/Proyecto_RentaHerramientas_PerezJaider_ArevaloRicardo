package com.herramientas.api.application.services;

import com.herramientas.api.persistence.entity.Pago;
import com.herramientas.api.persistence.repositories.PagoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public List<Pago> findAll() {
        return pagoRepository.findAll();
    }

    public Pago save(Pago pago) {
        return pagoRepository.save(pago);
    }
}