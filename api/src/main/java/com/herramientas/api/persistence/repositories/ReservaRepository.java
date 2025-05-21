package com.herramientas.api.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herramientas.api.persistence.entity.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}