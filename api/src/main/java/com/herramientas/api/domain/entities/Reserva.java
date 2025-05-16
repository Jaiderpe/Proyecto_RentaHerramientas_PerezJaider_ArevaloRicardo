package com.herramientas.api.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import com.herramientas.api.infrastructure.utils.Audit;

@Entity
@Table(name = "reservas", indexes = {
    @Index(name = "idx_reserva_herramienta", columnList = "id_herramienta"),
    @Index(name = "idx_reserva_cliente", columnList = "id_cliente")
})
@Getter
@Setter
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReserva;

    @ManyToOne
    @JoinColumn(name = "id_herramienta")
    private Herramienta herramienta;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Usuario cliente;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;

    @Embedded
    private Audit audit = new Audit();
}