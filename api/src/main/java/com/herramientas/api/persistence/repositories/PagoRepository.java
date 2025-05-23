package com.herramientas.api.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herramientas.api.persistence.entity.Pago;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
}