package com.herramientas.api.dto;

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