package com.herramientas.api.infrastructure.repositories;

import com.herramientas.api.domain.entities.Herramienta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HerramientaRepository extends JpaRepository<Herramienta, Integer> {
}