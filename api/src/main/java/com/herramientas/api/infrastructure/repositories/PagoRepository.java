package com.herramientas.api.infrastructure.repositories;

import com.herramientas.api.domain.entities.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
}