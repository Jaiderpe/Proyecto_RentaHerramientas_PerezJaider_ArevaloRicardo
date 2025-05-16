package com.herramientas.api.infrastructure.repositories;

import com.herramientas.api.domain.entities.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {
}