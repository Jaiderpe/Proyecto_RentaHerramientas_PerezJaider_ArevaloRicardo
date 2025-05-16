package com.herramientas.api.infrastructure.repositories;

import com.herramientas.api.domain.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}