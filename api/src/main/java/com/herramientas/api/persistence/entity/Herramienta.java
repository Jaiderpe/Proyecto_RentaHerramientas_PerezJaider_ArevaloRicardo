package com.herramientas.api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

import com.herramientas.api.persistence.utils.Audit;

@Entity
@Table(name = "herramientas")
@Getter @Setter
public class Herramienta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHerramienta;

    private String nombre;
    private String descripcion;
    private BigDecimal precioPorDia;
    private Boolean disponible = true;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Usuario proveedor;

    @Embedded
    private Audit audit = new Audit(); // <-- Aquí añadimos la auditoría
}