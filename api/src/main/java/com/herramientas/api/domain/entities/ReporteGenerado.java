package com.herramientas.api.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reportes_generados")
@Getter @Setter
@EqualsAndHashCode(of = "idReporte")
public class ReporteGenerado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReporte;
    private String tipoReporte;
    private LocalDateTime fechaGenerado;

    @ManyToOne
    @JoinColumn(name = "generado_por")
    private Usuario generadoPor;

    private String contenido;
}