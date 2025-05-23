package com.herramientas.api.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herramientas.api.persistence.entity.TipoDocumento;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {
}