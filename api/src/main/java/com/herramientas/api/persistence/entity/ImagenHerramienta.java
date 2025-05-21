package com.herramientas.api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "imagenes_herramienta")
@Getter @Setter
@EqualsAndHashCode(of = "idImagen")
public class ImagenHerramienta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idImagen;

    @ManyToOne
    @JoinColumn(name = "id_herramienta")
    private Herramienta herramienta;

    private String urlImagen;
    private Boolean principal = false;
}