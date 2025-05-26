package com.herramientas.api.application.services.impl;

import com.herramientas.api.application.services.UserService;
import com.herramientas.api.dto.SaveUser;
import com.herramientas.api.dto.UpdateUser;
import com.herramientas.api.exception.InvalidPasswordException;
import com.herramientas.api.persistence.entity.User;
import com.herramientas.api.persistence.repositories.UserRepository;
import com.herramientas.api.persistence.utils.Role;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

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
            user.setRole(Role.ROLE_CUSTOMER);
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

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findOneByEmail(String email) {
        if (!StringUtils.hasText(email)) {
            throw new IllegalArgumentException("El email no puede estar vacío");
        }
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public User updateUser(Long id, UpdateUser dto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con ID: " + id));

        existingUser.setFirstName(dto.getFirstName());
        existingUser.setLastName(dto.getLastName());
        existingUser.setPhone(dto.getPhone());
        existingUser.setRole(dto.getRole());

        if (StringUtils.hasText(dto.getEmail())) {
            existingUser.setEmail(dto.getEmail());
        }

        if (StringUtils.hasText(dto.getPassword())) {
            if (!dto.getPassword().equals(dto.getRepeatedPassword())) {
                throw new InvalidPasswordException("Las contraseñas no coinciden");
            }
            existingUser.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        return userRepository.save(existingUser);
    }

    @Override
    public User updateUser(Long id, SaveUser updateData) {
        return null;
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("No existe usuario con ID: " + id);
        }
        userRepository.deleteById(id);
    }

    private void validatePassword(SaveUser dto) {
        if (!StringUtils.hasText(dto.getPassword()) || !StringUtils.hasText(dto.getRepeatedPassword())) {
            throw new InvalidPasswordException("Passwords don't match");
        }
        if (!dto.getPassword().equals(dto.getRepeatedPassword())) {
            throw new InvalidPasswordException("Passwords don't match");
        }
    }
}
