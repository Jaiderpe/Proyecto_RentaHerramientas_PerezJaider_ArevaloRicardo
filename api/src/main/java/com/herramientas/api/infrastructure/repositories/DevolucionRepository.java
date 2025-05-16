package com.herramientas.api.infrastructure.repositories;

import com.herramientas.api.domain.entities.Devolucion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevolucionRepository extends JpaRepository<Devolucion, Integer> {
}