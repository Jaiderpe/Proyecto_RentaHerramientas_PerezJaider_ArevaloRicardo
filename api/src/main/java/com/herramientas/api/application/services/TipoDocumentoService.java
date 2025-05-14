package com.herramientas.api.application.services;

import com.herramientas.api.domain.dtos.TipoDocumentoDTO;
import com.herramientas.api.domain.entities.TipoDocumento;
import com.herramientas.api.infrastructure.repositories.TipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoDocumentoService {

    @Autowired
    private TipoDocumentoRepository repository;

    public List<TipoDocumentoDTO> getAllTiposDocumento() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public TipoDocumentoDTO getTipoDocumentoById(Integer id) {
        return repository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public TipoDocumentoDTO saveTipoDocumento(TipoDocumentoDTO dto) {
        TipoDocumento entity = convertToEntity(dto);
        return convertToDTO(repository.save(entity));
    }

    public void deleteTipoDocumento(Integer id) {
        repository.deleteById(id);
    }

    private TipoDocumentoDTO convertToDTO(TipoDocumento entity) {
        return TipoDocumentoDTO.builder()
                .idTipoDocumento(entity.getIdTipoDocumento())
                .nombre(entity.getNombre())
                .build();
    }

    private TipoDocumento convertToEntity(TipoDocumentoDTO dto) {
        return TipoDocumento.builder()
                .idTipoDocumento(dto.getIdTipoDocumento())
                .nombre(dto.getNombre())
                .build();
    }
}