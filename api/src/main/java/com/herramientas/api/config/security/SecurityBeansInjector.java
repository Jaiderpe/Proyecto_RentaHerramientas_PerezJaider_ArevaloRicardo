package com.herramientas.api.config.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.herramientas.api.exception.ObjectNotFoundException;
import com.herramientas.api.infrastructure.repositories.UserRepository;


@Configuration
public class SecurityBeansInjector {

    
    @Autowired
    private UserRepository userRepository;

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationStrategy = new DaoAuthenticationProvider();
        authenticationStrategy.setPasswordEncoder( passwordEncoder() );
        authenticationStrategy.setUserDetailsService( userDetailsService() );

        return authenticationStrategy;
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService(){
        return (username) -> {
            return userRepository.findByUsername(username)
                    .orElseThrow(() -> new ObjectNotFoundException("Usuario no encontrado con  username " + username));
        };
    }
}
