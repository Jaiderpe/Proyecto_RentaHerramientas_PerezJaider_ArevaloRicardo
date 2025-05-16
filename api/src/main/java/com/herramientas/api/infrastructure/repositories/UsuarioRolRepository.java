package com.herramientas.api.infrastructure.repositories;

import com.herramientas.api.domain.entities.UsuarioRol;
import com.herramientas.api.domain.entities.fkClass.UsuarioRolId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, UsuarioRolId> {
}