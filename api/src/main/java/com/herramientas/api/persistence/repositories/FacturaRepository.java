package com.herramientas.api.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herramientas.api.persistence.entity.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {
}