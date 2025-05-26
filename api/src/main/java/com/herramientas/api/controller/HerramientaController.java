package com.herramientas.api.controller;

import com.herramientas.api.application.services.HerramientaService;
import com.herramientas.api.dto.HerramientaDTO;
import com.herramientas.api.persistence.entity.Herramienta;
import com.herramientas.api.persistence.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/herramientas")
public class HerramientaController {

    @Autowired
    private HerramientaService herramientaService;

    @GetMapping
    public List<Herramienta> getAllHerramientas() {
        return herramientaService.findAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('PROVIDER')")
    public Herramienta createHerramienta(@RequestBody Herramienta herramienta,
                                         @AuthenticationPrincipal User proveedor) {
        herramienta.setProveedor(proveedor);
        return herramientaService.save(herramienta);
    }
    


    @DeleteMapping("/{id}")
    public void deleteHerramienta(@PathVariable Integer id) {
        herramientaService.deleteById(id);
    }

    //obtener herramientas del proveedor autenticado
    @GetMapping("/mis-herramientas")
    @PreAuthorize("hasRole('PROVIDER')")
    public List<HerramientaDTO> getHerramientasProveedor(@AuthenticationPrincipal User proveedor) {
        return herramientaService.findByProveedor(proveedor).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // actualizar herramienta
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('PROVIDER')")
    public Herramienta updateHerramienta(@PathVariable Integer id, @RequestBody Herramienta herramienta) {
        herramienta.setIdHerramienta(id);
        return herramientaService.save(herramienta);
    }

    //  Conversor Herramienta → DTO
    private HerramientaDTO convertToDto(Herramienta h) {
        return HerramientaDTO.builder()
                .idHerramienta(h.getIdHerramienta())
                .nombre(h.getNombre())
                .descripcion(h.getDescripcion())
                .precioPorDia(h.getPrecioPorDia().doubleValue())
                .disponible(h.getDisponible())
                .estado(h.getEstado())
                .idProveedor(h.getProveedor().getId())
                .imagenUrl(h.getImagenUrl())
                .build();
    }

        @GetMapping("/disponibles")
    public List<HerramientaDTO> getHerramientasDisponibles() {
        return herramientaService.findAll().stream()
            .filter(h -> Boolean.TRUE.equals(h.getDisponible()))
            .map(this::convertToDto)
            .collect(Collectors.toList());
    }


    
}
