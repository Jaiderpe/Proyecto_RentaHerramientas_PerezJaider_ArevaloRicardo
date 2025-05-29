package com.herramientas.api.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HerramientaDTOCliente {
    private Integer idHerramienta;
    private String nombre;
    private String descripcion;
    private Double precioPorDia;
    private String estado;
    private String imagenUrl;
}
