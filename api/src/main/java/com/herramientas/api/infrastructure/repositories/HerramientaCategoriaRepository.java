package com.herramientas.api.infrastructure.repositories;

import com.herramientas.api.domain.entities.HerramientaCategoria;
import com.herramientas.api.domain.entities.fkClass.HerramientaCategoriaId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HerramientaCategoriaRepository extends JpaRepository<HerramientaCategoria, HerramientaCategoriaId> {
}