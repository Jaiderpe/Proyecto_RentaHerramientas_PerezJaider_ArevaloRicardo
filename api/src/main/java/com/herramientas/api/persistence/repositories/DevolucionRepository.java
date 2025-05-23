package com.herramientas.api.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herramientas.api.persistence.entity.Devolucion;

public interface DevolucionRepository extends JpaRepository<Devolucion, Integer> {
}