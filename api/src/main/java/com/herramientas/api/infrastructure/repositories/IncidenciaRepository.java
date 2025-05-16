package com.herramientas.api.infrastructure.repositories;

import com.herramientas.api.domain.entities.Incidencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidenciaRepository extends JpaRepository<Incidencia, Integer> {
}