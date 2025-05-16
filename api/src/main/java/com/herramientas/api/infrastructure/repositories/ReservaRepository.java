package com.herramientas.api.infrastructure.repositories;

import com.herramientas.api.domain.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}