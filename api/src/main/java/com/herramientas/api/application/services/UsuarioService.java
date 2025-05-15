package com.herramientas.api.application.services;

import com.herramientas.api.domain.dtos.UsuarioDTO;
import com.herramientas.api.domain.entities.Usuario;
import com.herramientas.api.infrastructure.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<UsuarioDTO> getAllUsuarios() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO getUsuarioById(Integer id) {
        return repository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public UsuarioDTO saveUsuario(UsuarioDTO dto) {
        Usuario entity = convertToEntity(dto);
        return convertToDTO(repository.save(entity));
    }

    public void deleteUsuario(Integer id) {
        repository.deleteById(id);
    }

    public UsuarioDTO updateUsuario(Integer id, UsuarioDTO dto) {
        if (!dto.getIdUsuario().equals(id)) {
            throw new IllegalArgumentException("ID no coincide");
        }
        return convertToDTO(repository.save(convertToEntity(dto)));
    }

    private UsuarioDTO convertToDTO(Usuario entity) {
        return UsuarioDTO.builder()
                .idUsuario(entity.getIdUsuario())
                .nombre(entity.getNombre())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .idTipoDocumento(entity.getIdTipoDocumento())
                .numeroDocumento(entity.getNumeroDocumento())
                .telefono(entity.getTelefono())
                .direccion(entity.getDireccion())
                .activo(entity.getActivo())
                .build();
    }

    private Usuario convertToEntity(UsuarioDTO dto) {
        return Usuario.builder()
                .idUsuario(dto.getIdUsuario())
                .nombre(dto.getNombre())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .idTipoDocumento(dto.getIdTipoDocumento())
                .numeroDocumento(dto.getNumeroDocumento())
                .telefono(dto.getTelefono())
                .direccion(dto.getDireccion())
                .activo(dto.getActivo())
                .build();
    }
}