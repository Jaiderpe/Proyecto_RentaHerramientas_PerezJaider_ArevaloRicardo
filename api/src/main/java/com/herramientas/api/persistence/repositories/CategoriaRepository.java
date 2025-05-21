package com.herramientas.api.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herramientas.api.persistence.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}