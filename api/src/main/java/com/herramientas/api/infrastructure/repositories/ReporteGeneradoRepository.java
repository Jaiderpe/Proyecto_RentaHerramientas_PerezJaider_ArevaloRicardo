package com.herramientas.api.infrastructure.repositories;

import com.herramientas.api.domain.entities.ReporteGenerado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReporteGeneradoRepository extends JpaRepository<ReporteGenerado, Integer> {
}