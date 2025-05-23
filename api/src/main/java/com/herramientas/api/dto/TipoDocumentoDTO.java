package com.herramientas.api.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoDocumentoDTO {
    private Integer idTipoDocumento;
    private String nombre;
}