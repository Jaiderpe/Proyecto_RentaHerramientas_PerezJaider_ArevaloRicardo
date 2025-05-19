package com.herramientas.api.application.services;

import com.herramientas.api.domain.entities.*;
import com.herramientas.api.domain.dtos.*;
import com.herramientas.api.infrastructure.repositories.UsuarioRepository;
import com.herramientas.api.security.JwtService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponse login(LoginRequest request) {
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Credenciales inválidas");
        }

        String token = jwtService.generateToken(usuario);
        return new AuthResponse(token);
    }

    public AuthResponse register(RegisterRequest request) {
        Usuario usuario = new Usuario();
        usuario.setNombre(request.getNombre());
        usuario.setEmail(request.getEmail());
        usuario.setPassword(passwordEncoder.encode(request.getPassword()));
        usuario.setDireccion(request.getDireccion());
        usuario.setNumeroDocumento(request.getNumeroDocumento());
        usuario.setTelefono(request.getTelefono());
        usuario.setActivo(true);
        usuario.setRoles(Set.of(new Rol(2, "ROLE_CLIENTE"))); // asignar el rol correcto según tu base

        usuarioRepository.save(usuario);

        String token = jwtService.generateToken(usuario);
        return new AuthResponse(token);
    }
}
