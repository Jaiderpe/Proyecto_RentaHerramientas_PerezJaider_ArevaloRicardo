package com.herramientas.api.application.services;

import com.herramientas.api.domain.dtos.RolDTO;
import com.herramientas.api.domain.entities.Rol;
import com.herramientas.api.infrastructure.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolService {

    @Autowired
    private RolRepository repository;

    public List<RolDTO> getAllRoles() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public RolDTO getRolById(Integer id) {
        return repository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public RolDTO saveRol(RolDTO dto) {
        Rol entity = convertToEntity(dto);
        return convertToDTO(repository.save(entity));
    }

    public void deleteRol(Integer id) {
        repository.deleteById(id);
    }

    public RolDTO updateRol(Integer id, RolDTO dto) {
        if (!dto.getIdRol().equals(id)) {
            throw new IllegalArgumentException("ID no coincide");
        }
        return convertToDTO(repository.save(convertToEntity(dto)));
    }

    private RolDTO convertToDTO(Rol entity) {
        return RolDTO.builder()
                .idRol(entity.getIdRol())
                .nombre(entity.getNombre())
                .build();
    }

    private Rol convertToEntity(RolDTO dto) {
        return Rol.builder()
                .idRol(dto.getIdRol())
                .nombre(dto.getNombre())
                .build();
    }
}