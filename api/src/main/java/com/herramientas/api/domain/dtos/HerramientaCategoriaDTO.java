package com.herramientas.api.domain.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HerramientaCategoriaDTO {
    private Integer idHerramienta;
    private Integer idCategoria;
}