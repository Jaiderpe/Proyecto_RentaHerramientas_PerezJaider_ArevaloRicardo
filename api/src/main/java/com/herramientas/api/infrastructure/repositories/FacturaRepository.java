package com.herramientas.api.infrastructure.repositories;

import com.herramientas.api.domain.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {
}