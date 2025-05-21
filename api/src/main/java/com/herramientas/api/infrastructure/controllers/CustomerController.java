package com.herramientas.api.infrastructure.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herramientas.api.application.services.auth.AuthenticationService;
import com.herramientas.api.domain.dtos.RegisteredUser;
import com.herramientas.api.domain.dtos.SaveUser;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<RegisteredUser> register(@RequestBody @Valid SaveUser saveUser) {
        RegisteredUser registeredUser = authenticationService.registerOneCustomer(saveUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }

}


