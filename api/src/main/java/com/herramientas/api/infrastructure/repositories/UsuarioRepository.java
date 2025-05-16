package com.herramientas.api.infrastructure.repositories;

import com.herramientas.api.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}