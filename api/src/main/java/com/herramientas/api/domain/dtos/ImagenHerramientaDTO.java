package com.herramientas.api.domain.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImagenHerramientaDTO {
    private Integer idImagen;
    private Integer idHerramienta;
    private String urlImagen;
    private Boolean principal;
}