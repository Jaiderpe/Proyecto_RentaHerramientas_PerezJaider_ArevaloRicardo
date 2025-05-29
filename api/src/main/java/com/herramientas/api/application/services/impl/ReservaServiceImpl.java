package com.herramientas.api.application.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herramientas.api.application.services.ReservaService;
import com.herramientas.api.persistence.entity.Herramienta;
import com.herramientas.api.persistence.entity.Reserva;
import com.herramientas.api.persistence.entity.User;
import com.herramientas.api.persistence.repositories.HerramientaRepository;
import com.herramientas.api.persistence.repositories.ReservaRepository;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private HerramientaRepository herramientaRepository;

    @Override
    public Reserva crearReserva(Reserva reserva) {
        Herramienta herramienta = herramientaRepository.findById(reserva.getHerramienta().getIdHerramienta())
                .orElseThrow(() -> new IllegalArgumentException("Herramienta no encontrada"));

        long dias = ChronoUnit.DAYS.between(reserva.getFechaInicio(), reserva.getFechaFin());
        BigDecimal monto = herramienta.getPrecioPorDia().multiply(BigDecimal.valueOf(dias));

        reserva.setHerramienta(herramienta);
        reserva.setMonto(monto);
        reserva.setEstado("PENDIENTE");

        return reservaRepository.save(reserva);
    }

    @Override
    public List<Reserva> obtenerReservasPorCliente(User cliente) {
        return reservaRepository.findByCliente(cliente);
    }
}
