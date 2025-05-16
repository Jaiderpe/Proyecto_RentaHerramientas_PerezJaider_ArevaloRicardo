package com.herramientas.api.infrastructure.repositories;

import com.herramientas.api.domain.entities.HistorialEstadoHerramienta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistorialEstadoHerramientaRepository extends JpaRepository<HistorialEstadoHerramienta, Integer> {
}