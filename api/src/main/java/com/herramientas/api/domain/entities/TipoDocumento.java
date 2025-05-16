package com.herramientas.api.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipos_documento")
@Getter @Setter
@EqualsAndHashCode(of = "idTipoDocumento")
public class TipoDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoDocumento;
    private String nombre;
}