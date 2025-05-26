package com.herramientas.api.persistence.repositories;

import com.herramientas.api.persistence.entity.Reserva;
import com.herramientas.api.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByCliente(User cliente);
    List<Reserva> findByHerramienta_Proveedor(User proveedor);
}

