package com.herramientas.api.domain.entities;

import com.herramientas.api.domain.entities.fkClass.HerramientaCategoriaId;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "herramienta_categoria")
@IdClass(HerramientaCategoriaId.class)
@Getter @Setter
public class HerramientaCategoria {

    @Id
    @Column(name = "id_herramienta", insertable = false, updatable = false)
    private Integer idHerramienta;

    @Id
    @Column(name = "id_categoria", insertable = false, updatable = false)
    private Integer idCategoria;

    @ManyToOne
    @JoinColumn(name = "id_herramienta")
    private Herramienta herramienta;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
}