package com.herramientas.api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import com.herramientas.api.persistence.utils.EstadoReserva;

@Entity
@Table(name = "reservas")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    @ManyToOne
    @JoinColumn(name = "id_herramienta")
    private Herramienta herramienta;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private User cliente;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;

    private String observaciones;
}

