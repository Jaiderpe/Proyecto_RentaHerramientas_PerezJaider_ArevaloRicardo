package com.herramientas.api.application.services;

import com.herramientas.api.persistence.entity.UsuarioRol;
import com.herramientas.api.persistence.repositories.UsuarioRolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioRolService {

    @Autowired
    private UsuarioRolRepository usuarioRolRepository;

    public List<UsuarioRol> findAll() {
        return usuarioRolRepository.findAll();
    }

    public UsuarioRol save(UsuarioRol usuarioRol) {
        return usuarioRolRepository.save(usuarioRol);
    }
}