package com.herramientas.api.application.services;

import com.herramientas.api.domain.entities.ReporteGenerado;
import com.herramientas.api.infrastructure.repositories.ReporteGeneradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteGeneradoService {

    @Autowired
    private ReporteGeneradoRepository reporteGeneradoRepository;

    public List<ReporteGenerado> findAll() {
        return reporteGeneradoRepository.findAll();
    }

    public ReporteGenerado save(ReporteGenerado reporte) {
        return reporteGeneradoRepository.save(reporte);
    }
}