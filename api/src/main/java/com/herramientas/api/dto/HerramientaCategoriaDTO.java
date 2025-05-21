package com.herramientas.api.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HerramientaCategoriaDTO {
    private Integer idHerramienta;
    private Integer idCategoria;
}