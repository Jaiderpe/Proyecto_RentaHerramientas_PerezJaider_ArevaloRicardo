package com.herramientas.api.infrastructure.repositories;

import com.herramientas.api.domain.entities.ImagenHerramienta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenHerramientaRepository extends JpaRepository<ImagenHerramienta, Integer> {
}