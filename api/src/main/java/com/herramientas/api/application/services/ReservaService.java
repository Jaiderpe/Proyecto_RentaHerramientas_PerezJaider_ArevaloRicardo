package com.herramientas.api.application.services;

import com.herramientas.api.persistence.entity.Reserva;
import com.herramientas.api.persistence.repositories.ReservaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }
}