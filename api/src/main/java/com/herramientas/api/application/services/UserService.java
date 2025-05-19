package com.herramientas.api.application.services;

import java.util.Optional;

import com.herramientas.api.domain.dtos.SaveUser;
import com.herramientas.api.domain.entities.User;

public interface UserService {
    User registrOneCustomer(SaveUser newUser);

    Optional<User> findOneByUsername(String username);
}
