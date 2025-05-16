package com.herramientas.api.domain.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HerramientaDTO {
    private Integer idHerramienta;
    private String nombre;
    private String descripcion;
    private Double precioPorDia;
    private Boolean disponible;
    private String estado;
    private Integer idProveedor;
}