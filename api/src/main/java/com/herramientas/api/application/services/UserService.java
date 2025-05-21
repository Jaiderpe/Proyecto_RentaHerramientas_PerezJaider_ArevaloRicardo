package com.herramientas.api.application.services;

import java.util.Optional;

import com.herramientas.api.dto.SaveUser;
import com.herramientas.api.persistence.entity.User;

public interface UserService {
    User registrOneCustomer(SaveUser newUser);

    Optional<User> findOneByUsername(String username);
}
