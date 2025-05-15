package com.herramientas.api.application.services;

import com.herramientas.api.domain.dtos.ImagenHerramientaDTO;
import com.herramientas.api.domain.entities.ImagenHerramienta;
import com.herramientas.api.infrastructure.repositories.HerramientaRepository;
import com.herramientas.api.infrastructure.repositories.ImagenHerramientaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImagenHerramientaService {

    @Autowired
    private ImagenHerramientaRepository repository;

    @Autowired
    private HerramientaRepository herramientaRepository;

    public List<ImagenHerramientaDTO> getAllImagenes() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ImagenHerramientaDTO getImagenById(Integer id) {
        return repository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public ImagenHerramientaDTO saveImagen(ImagenHerramientaDTO dto) {
        ImagenHerramienta entity = convertToEntity(dto);
        return convertToDTO(repository.save(entity));
    }

    public void deleteImagen(Integer id) {
        repository.deleteById(id);
    }

    public ImagenHerramientaDTO updateImagen(Integer id, ImagenHerramientaDTO dto) {
        if (!dto.getIdImagen().equals(id)) {
            throw new IllegalArgumentException("ID no coincide");
        }
        return convertToDTO(repository.save(convertToEntity(dto)));
    }

    private ImagenHerramientaDTO convertToDTO(ImagenHerramienta entity) {
        return ImagenHerramientaDTO.builder()
                .idImagen(entity.getIdImagen())
                .idHerramienta(entity.getHerramienta().getIdHerramienta())
                .urlImagen(entity.getUrlImagen())
                .principal(entity.getPrincipal())
                .build();
    }

    private ImagenHerramienta convertToEntity(ImagenHerramientaDTO dto) {
        return ImagenHerramienta.builder()
                .idImagen(dto.getIdImagen())
                .herramienta(herramientaRepository.findById(dto.getIdHerramienta()).orElse(null))
                .urlImagen(dto.getUrlImagen())
                .principal(dto.getPrincipal())
                .build();
    }
}