package com.herramientas.api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "reservas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_herramienta")
    private Herramienta herramienta;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private User cliente;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado; // PENDIENTE, ACEPTADA, RECHAZADA, FINALIZADA
    private BigDecimal monto;
}

