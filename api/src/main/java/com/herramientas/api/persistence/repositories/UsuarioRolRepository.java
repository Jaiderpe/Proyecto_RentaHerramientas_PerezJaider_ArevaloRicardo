package com.herramientas.api.persistence.repositories;

import com.herramientas.api.persistence.entity.UsuarioRol;
import com.herramientas.api.persistence.entity.fkClass.UsuarioRolId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, UsuarioRolId> {
}