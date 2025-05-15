package com.herramientas.api.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "imagenes_herramienta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImagenHerramienta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagen")
    private Integer idImagen;

    @ManyToOne
    @JoinColumn(name = "id_herramienta", nullable = false)
    private Herramienta herramienta;

    @Column(name = "url_imagen", columnDefinition = "TEXT")
    private String urlImagen;

    @Column(name = "principal")
    private Boolean principal = false;
}