package com.herramientas.api.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herramientas.api.persistence.entity.Incidencia;

public interface IncidenciaRepository extends JpaRepository<Incidencia, Integer> {
}