package com.herramientas.api.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herramientas.api.domain.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);

}
