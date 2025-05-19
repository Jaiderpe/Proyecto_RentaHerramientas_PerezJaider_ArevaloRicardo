package com.herramientas.api.security;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.herramientas.api.domain.entities.Usuario;
import com.herramientas.api.infrastructure.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioDetailsService implements UserDetailsService{

      private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return new org.springframework.security.core.userdetails.User(
                usuario.getEmail(),
                usuario.getPassword(),
                usuario.getRoles().stream()
                        .map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
                        .collect(Collectors.toList())
        );
}
}
