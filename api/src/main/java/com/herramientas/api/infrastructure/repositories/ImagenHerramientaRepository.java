package com.herramientas.api.infrastructure.repositories;

import com.herramientas.api.domain.entities.ImagenHerramienta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagenHerramientaRepository extends JpaRepository<ImagenHerramienta, Integer> {
    List<ImagenHerramienta> findByHerramientaIdHerramienta(Integer idHerramienta);
}