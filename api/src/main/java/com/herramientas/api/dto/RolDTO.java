package com.herramientas.api.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RolDTO {
    private Integer idRol;
    private String nombre;
}