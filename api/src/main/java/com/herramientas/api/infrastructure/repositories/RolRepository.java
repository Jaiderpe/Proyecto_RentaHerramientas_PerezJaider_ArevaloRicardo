package com.herramientas.api.infrastructure.repositories;

import com.herramientas.api.domain.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Integer> {
}