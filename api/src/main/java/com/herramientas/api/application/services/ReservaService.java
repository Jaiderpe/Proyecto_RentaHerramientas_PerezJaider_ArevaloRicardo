package com.herramientas.api.application.services;

import com.herramientas.api.persistence.entity.Reserva;
import com.herramientas.api.persistence.entity.User;
import com.herramientas.api.persistence.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public void deleteById(Long id) {
        reservaRepository.deleteById(id);
    }

    public List<Reserva> getReservasByCliente(User cliente) {
        return reservaRepository.findByCliente(cliente);
    }

    public List<Reserva> getReservasByProveedor(User proveedor) {
        return reservaRepository.findByHerramienta_Proveedor(proveedor);
    }
}
