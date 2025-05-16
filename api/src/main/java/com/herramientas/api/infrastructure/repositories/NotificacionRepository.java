package com.herramientas.api.infrastructure.repositories;

import com.herramientas.api.domain.entities.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacionRepository extends JpaRepository<Notificacion, Integer> {
}