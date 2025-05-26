package com.herramientas.api.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservaDto {
    private Long idReserva;
    private String herramientaNombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;
}
