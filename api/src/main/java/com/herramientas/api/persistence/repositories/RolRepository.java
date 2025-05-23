package com.herramientas.api.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herramientas.api.persistence.entity.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {
}