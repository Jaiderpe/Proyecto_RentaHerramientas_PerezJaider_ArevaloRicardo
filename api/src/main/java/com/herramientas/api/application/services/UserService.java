package com.herramientas.api.application.services;

import com.herramientas.api.dto.SaveUser;
import com.herramientas.api.dto.UpdateUser;
import com.herramientas.api.persistence.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User registrOneCustomer(SaveUser newUser);
    Optional<User> findOneByUsername(String username);
    List<User> findAll();
    Optional<User> findOneByEmail(String email);
    Optional<User> findById(Long id);
    User updateUser(Long id, SaveUser updateData); 
    User updateUser(Long id, UpdateUser updateData); 
    void deleteUser(Long id);
}
