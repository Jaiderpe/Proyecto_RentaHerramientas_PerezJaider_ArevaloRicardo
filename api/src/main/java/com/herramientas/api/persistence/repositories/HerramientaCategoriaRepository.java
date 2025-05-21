package com.herramientas.api.persistence.repositories;

import com.herramientas.api.persistence.entity.HerramientaCategoria;
import com.herramientas.api.persistence.entity.fkClass.HerramientaCategoriaId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HerramientaCategoriaRepository extends JpaRepository<HerramientaCategoria, HerramientaCategoriaId> {
}