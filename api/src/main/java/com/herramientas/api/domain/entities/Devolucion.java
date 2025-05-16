package com.herramientas.api.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "devoluciones")
@Getter @Setter
@EqualsAndHashCode(of = "idDevolucion")
public class Devolucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDevolucion;

    @OneToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;

    private LocalDate fechaDevolucion;
    private String estadoHerramienta;
    private String observaciones;
}