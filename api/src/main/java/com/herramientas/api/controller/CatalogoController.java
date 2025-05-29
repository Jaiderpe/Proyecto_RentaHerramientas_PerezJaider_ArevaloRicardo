package com.herramientas.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.herramientas.api.application.services.HerramientaService;
import com.herramientas.api.dto.HerramientaDTOCliente;
import com.herramientas.api.persistence.entity.Herramienta;

@RestController
@RequestMapping("/cliente/catalogo")
public class CatalogoController {

    @Autowired
    private HerramientaService herramientaService;

    @GetMapping
    public List<HerramientaDTOCliente> verHerramientasDisponibles() {
        return herramientaService.findDisponibles().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private HerramientaDTOCliente convertToDto(Herramienta h) {
        return HerramientaDTOCliente.builder()
                .idHerramienta(h.getIdHerramienta())
                .nombre(h.getNombre())
                .descripcion(h.getDescripcion())
                .precioPorDia(h.getPrecioPorDia().doubleValue())
                .estado(h.getEstado())
                .imagenUrl(h.getImagenUrl())
                .build();
    }
}
