package com.herramientas.api.dto;

import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {
    private Integer idUsuario;
    private String nombre;
    private String email;
    private String password;
    private Integer idTipoDocumento;
    private String numeroDocumento;
    private String telefono;
    private String direccion;
    private Boolean activo;
    private Set<Integer> rolesIds;
}