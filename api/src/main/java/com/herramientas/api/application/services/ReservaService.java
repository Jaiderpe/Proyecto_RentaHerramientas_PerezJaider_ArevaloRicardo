package com.herramientas.api.application.services;

import java.util.List;

import com.herramientas.api.persistence.entity.Reserva;
import com.herramientas.api.persistence.entity.User;

public interface ReservaService {
    Reserva crearReserva(Reserva reserva);
    List<Reserva> obtenerReservasPorCliente(User cliente);
}
