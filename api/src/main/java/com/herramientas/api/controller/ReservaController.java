package com.herramientas.api.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.herramientas.api.application.services.ReservaService;
import com.herramientas.api.persistence.entity.Reserva;
import com.herramientas.api.persistence.entity.User;

@RestController
@RequestMapping("/cliente/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public Reserva crearReserva(@RequestBody Reserva reserva,
                                @AuthenticationPrincipal User cliente) {
        reserva.setCliente(cliente);
        return reservaService.crearReserva(reserva);
    }

    @GetMapping
    public List<Reserva> obtenerMisReservas(@AuthenticationPrincipal User cliente) {
        return reservaService.obtenerReservasPorCliente(cliente);
    }
}



