package com.herramientas.api.domain.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoDocumentoDTO {
    private Integer idTipoDocumento;
    private String nombre;
}