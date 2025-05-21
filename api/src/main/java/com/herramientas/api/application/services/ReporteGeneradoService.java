package com.herramientas.api.application.services;

import com.herramientas.api.persistence.entity.ReporteGenerado;
import com.herramientas.api.persistence.repositories.ReporteGeneradoRepository;

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