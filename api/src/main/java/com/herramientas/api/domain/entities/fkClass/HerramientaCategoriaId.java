package com.herramientas.api.domain.entities.fkClass;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class HerramientaCategoriaId implements Serializable {
    private Integer idHerramienta;
    private Integer idCategoria;
}