package com.herramientas.api.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "historial_estado_herramienta")
@Getter @Setter
@EqualsAndHashCode(of = "idHistorial")
public class HistorialEstadoHerramienta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHistorial;

    @ManyToOne
    @JoinColumn(name = "id_herramienta")
    private Herramienta herramienta;

    private String estado;
    private LocalDateTime fechaCambio;
    private String observaciones;
}