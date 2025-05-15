package com.herramientas.api.domain.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RolDTO {
    private Integer idRol;
    private String nombre;
}