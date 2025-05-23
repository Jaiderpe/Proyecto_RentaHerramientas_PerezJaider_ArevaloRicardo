package com.herramientas.api.persistence.entity.fkClass;

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