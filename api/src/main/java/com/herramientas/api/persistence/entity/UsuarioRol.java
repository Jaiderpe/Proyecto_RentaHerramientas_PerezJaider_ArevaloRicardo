package com.herramientas.api.persistence.entity;

import com.herramientas.api.persistence.entity.fkClass.UsuarioRolId;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario_roles")
@IdClass(UsuarioRolId.class)
@Getter @Setter
@EqualsAndHashCode(of = {"idUsuario", "idRol"})
public class UsuarioRol {

    @Id
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Id
    @Column(name = "id_rol")
    private Integer idRol;

    @ManyToOne
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_rol", insertable = false, updatable = false)
    private Rol rol;
}