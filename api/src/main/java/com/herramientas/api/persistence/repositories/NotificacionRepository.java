package com.herramientas.api.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herramientas.api.persistence.entity.Notificacion;

public interface NotificacionRepository extends JpaRepository<Notificacion, Integer> {
}