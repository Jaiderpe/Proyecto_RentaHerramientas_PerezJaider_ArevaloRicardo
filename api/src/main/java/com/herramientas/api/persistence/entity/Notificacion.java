package com.herramientas.api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;


@EqualsAndHashCode(of = "idNotificacion")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNotificacion;

   
}