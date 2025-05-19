package com.herramientas.api.security;

import com.herramientas.api.domain.entities.Usuario;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.stream.Collectors;

@Service
public class JwtService {

    private final String SECRET_KEY = "mi_clave_secreta_super_segura";

    public String generateToken(Usuario usuario) {
        return Jwts.builder()
                .setSubject(usuario.getEmail())
                .claim("roles", usuario.getRoles().stream()
                        .map(r -> r.getNombre())
                        .collect(Collectors.toList()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10h
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token)
                .getBody().getSubject();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()));
    }
}
