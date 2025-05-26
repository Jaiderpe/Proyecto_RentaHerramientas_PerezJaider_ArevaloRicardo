package com.herramientas.api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

import com.herramientas.api.persistence.utils.Audit;

@Entity
@Table(name = "herramientas")
@Getter
@Setter
public class Herramienta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHerramienta;

    private String nombre;
    private String descripcion;
    private BigDecimal precioPorDia;
    private Boolean disponible = true;
    private String estado;
    @Column(name = "imagen_url")
    private String imagenUrl;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private User proveedor;

    @ManyToMany
    @JoinTable(name = "herramienta_categoria", joinColumns = @JoinColumn(name = "id_herramienta"), inverseJoinColumns = @JoinColumn(name = "id_categoria"))
    private Set<Categoria> categorias; // Usa Set para evitar duplicados

    @Embedded
    private Audit audit = new Audit();
}