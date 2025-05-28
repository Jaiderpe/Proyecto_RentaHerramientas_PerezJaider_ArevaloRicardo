package com.herramientas.api.controller;

import com.herramientas.api.application.services.ReservaService;
import com.herramientas.api.dto.ReservaDto;
import com.herramientas.api.persistence.entity.Reserva;
import com.herramientas.api.persistence.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    @PreAuthorize("hasRole('CUSTOMER')")
    public Reserva crearReserva(@RequestBody Reserva reserva, @AuthenticationPrincipal User cliente) {
        reserva.setCliente(cliente);
        reserva.setEstado(com.herramientas.api.persistence.utils.EstadoReserva.PENDIENTE);
        return reservaService.save(reserva);
    }

    @GetMapping("/proveedor")
    @PreAuthorize("hasRole('PROVIDER')")
    public List<Reserva> reservasProveedor(@AuthenticationPrincipal User proveedor) {
        return reservaService.getReservasByProveedor(proveedor);
    }

    @PutMapping("/{id}/estado")
    @PreAuthorize("hasRole('PROVIDER')")
    public Reserva cambiarEstadoReserva(@PathVariable Long id, @RequestBody String nuevoEstado) {
        Reserva reserva = reservaService.save(new Reserva()); // Placeholder
        // Aquí deberías recuperar la reserva, validar acceso y actualizar el estado.
        return reserva;
    }



 @GetMapping("/cliente")
@PreAuthorize("hasRole('CUSTOMER')")
public List<Reserva> getReservasCliente(@AuthenticationPrincipal User cliente) {
    return reservaService.getReservasByCliente(cliente);
}
}



