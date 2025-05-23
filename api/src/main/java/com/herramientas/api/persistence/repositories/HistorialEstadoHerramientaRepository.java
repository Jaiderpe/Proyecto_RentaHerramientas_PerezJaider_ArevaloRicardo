package com.herramientas.api.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herramientas.api.persistence.entity.HistorialEstadoHerramienta;

public interface HistorialEstadoHerramientaRepository extends JpaRepository<HistorialEstadoHerramienta, Integer> {
}