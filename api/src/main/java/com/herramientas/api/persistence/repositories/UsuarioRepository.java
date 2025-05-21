package com.herramientas.api.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herramientas.api.persistence.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}