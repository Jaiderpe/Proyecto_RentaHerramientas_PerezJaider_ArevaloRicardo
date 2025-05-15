package com.herramientas.api.infrastructure.repositories;

import com.herramientas.api.domain.entities.Herramienta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HerramientaRepository extends JpaRepository<Herramienta, Integer> {

    // Opción 1: Usar el nombre correcto del campo anidado
    List<Herramienta> findByProveedorIdUsuario(Integer idUsuario);

    // Opción 2: Usar JPQL explícito
    @Query("SELECT h FROM Herramienta h WHERE h.proveedor.idUsuario = ?1")
    List<Herramienta> findByProveedorId(Integer idProveedor);
}