package com.herramientas.api.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "herramientas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Herramienta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_herramienta")
    private Integer idHerramienta;

    private String nombre;
    private String descripcion;
    private Double precioPorDia;

    @Column(name = "disponible")
    private Boolean disponible = true;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Usuario proveedor;
}