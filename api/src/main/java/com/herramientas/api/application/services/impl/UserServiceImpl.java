package com.herramientas.api.application.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import com.herramientas.api.application.services.UserService;
import com.herramientas.api.dto.SaveUser;
import com.herramientas.api.exception.InvalidPasswordException;
import com.herramientas.api.persistence.entity.User;
import com.herramientas.api.persistence.repositories.UserRepository;
import com.herramientas.api.persistence.utils.Role;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registrOneCustomer(SaveUser newUser) {
        validatePassword(newUser);
    
        if (userRepository.findByEmail(newUser.getEmail()).isPresent()) {
            throw new IllegalArgumentException("El correo ya está registrado");
        }
    
        User user = new User();
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());
        user.setPhone(newUser.getPhone());
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
    
        if (newUser.getRole() == null || newUser.getRole().isEmpty()) {
            user.setRole(Role.ROLE_CUSTOMER); // Por defecto es cliente
        } else {
            try {
                user.setRole(Role.valueOf(newUser.getRole()));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Rol no válido");
            }
        }
    
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findOneByUsername(String email) {
        return userRepository.findByEmail(email);
    }

    private void validatePassword(SaveUser dto) {
        if (!StringUtils.hasText(dto.getPassword()) || !StringUtils.hasText(dto.getRepeatedPassword())) {
            throw new InvalidPasswordException("Passwords don't match");
        }
        if (!dto.getPassword().equals(dto.getRepeatedPassword())) {
            throw new InvalidPasswordException("Passwords don't match");
        }
    }

    @Override
    public List<User> findAll() {
    return userRepository.findAll();
}
}