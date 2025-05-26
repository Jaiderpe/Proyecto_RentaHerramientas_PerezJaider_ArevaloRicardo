package com.herramientas.api.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herramientas.api.persistence.entity.Herramienta;
import com.herramientas.api.persistence.entity.User;

public interface HerramientaRepository extends JpaRepository<Herramienta, Integer> {
    List<Herramienta> findByProveedor(User proveedor);
    List<Herramienta> findByCategorias_IdCategoria(Integer idCategoria);
}