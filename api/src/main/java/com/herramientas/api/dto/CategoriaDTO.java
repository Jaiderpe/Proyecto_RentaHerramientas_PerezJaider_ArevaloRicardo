package com.herramientas.api.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaDTO {
    private Integer idCategoria;
    private String nombre;
}