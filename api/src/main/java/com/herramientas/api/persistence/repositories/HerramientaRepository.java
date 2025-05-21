package com.herramientas.api.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herramientas.api.persistence.entity.Herramienta;

public interface HerramientaRepository extends JpaRepository<Herramienta, Integer> {
}