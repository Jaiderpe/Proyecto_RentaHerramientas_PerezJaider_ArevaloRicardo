package com.herramientas.api.domain.entities.fkClass;

import lombok.*;
import java.io.Serializable;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRolId implements Serializable {
    private Integer idUsuario;
    private Integer idRol;
}