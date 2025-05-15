package com.herramientas.api.application.services;

import com.herramientas.api.domain.dtos.HerramientaDTO;
import com.herramientas.api.domain.entities.Herramienta;
import com.herramientas.api.infrastructure.repositories.HerramientaRepository;
import com.herramientas.api.infrastructure.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HerramientaService {

    @Autowired
    private HerramientaRepository herramientaRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    public List<HerramientaDTO> getAllHerramientas() {
        return herramientaRepo.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public HerramientaDTO getHerramientaById(Integer id) {
        return herramientaRepo.findById(id).map(this::convertToDTO).orElse(null);
    }

    public HerramientaDTO saveHerramienta(HerramientaDTO dto) {
        Herramienta entity = convertToEntity(dto);
        return convertToDTO(herramientaRepo.save(entity));
    }

    public void deleteHerramienta(Integer id) {
        herramientaRepo.deleteById(id);
    }

    public HerramientaDTO updateHerramienta(Integer id, HerramientaDTO dto) {
        if (!dto.getIdHerramienta().equals(id)) {
            throw new IllegalArgumentException("ID no coincide");
        }
        return convertToDTO(herramientaRepo.save(convertToEntity(dto)));
    }

    private HerramientaDTO convertToDTO(Herramienta entity) {
        return HerramientaDTO.builder()
                .idHerramienta(entity.getIdHerramienta())
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .precioPorDia(entity.getPrecioPorDia())
                .disponible(entity.getDisponible())
                .estado(entity.getEstado())
                .idProveedor(entity.getProveedor().getIdUsuario())
                .build();
    }

    private Herramienta convertToEntity(HerramientaDTO dto) {
        return Herramienta.builder()
                .idHerramienta(dto.getIdHerramienta())
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .precioPorDia(dto.getPrecioPorDia())
                .disponible(dto.getDisponible())
                .estado(dto.getEstado())
                .proveedor(usuarioRepo.findById(dto.getIdProveedor()).orElse(null))
                .build();
    }
}