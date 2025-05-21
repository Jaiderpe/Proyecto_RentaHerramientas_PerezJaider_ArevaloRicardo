package com.herramientas.api.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herramientas.api.persistence.entity.ImagenHerramienta;

public interface ImagenHerramientaRepository extends JpaRepository<ImagenHerramienta, Integer> {
}