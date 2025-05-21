package com.herramientas.api.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herramientas.api.persistence.entity.ReporteGenerado;

public interface ReporteGeneradoRepository extends JpaRepository<ReporteGenerado, Integer> {
}