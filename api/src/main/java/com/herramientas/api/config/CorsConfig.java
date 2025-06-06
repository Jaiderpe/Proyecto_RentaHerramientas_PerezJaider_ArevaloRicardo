package com.herramientas.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Configuración global para todas las rutas
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5500", "http://127.0.0.1:5500", "http://127.0.0.1:5501", "http://127.0.0.1:5502")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
        
        // Configuraciones específicas (opcional, ya cubiertas por /**)
        registry.addMapping("/auth/**")
                .allowedOrigins("http://localhost:5500", "http://127.0.0.1:5501", "http://127.0.0.1:5502")
                .allowedMethods("GET", "POST", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);

        registry.addMapping("/customers/**")
                .allowedOrigins("http://localhost:5500", "http://127.0.0.1:5501", "http://127.0.0.1:5502")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
        
        // Configuración específica para admin
        registry.addMapping("/admin/**")
                .allowedOrigins("http://localhost:5500", "http://127.0.0.1:5501", "http://127.0.0.1:5502")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}