package com.herramientas.api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "facturas")
@Getter @Setter
@EqualsAndHashCode(of = "idFactura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFactura;

    @OneToOne
    @JoinColumn(name = "id_pago")
    private Pago pago;

    private LocalDateTime fechaEmision;
    private BigDecimal total;
    private String archivoPdf;
}