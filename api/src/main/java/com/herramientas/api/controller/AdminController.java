package com.herramientas.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.herramientas.api.application.services.auth.AuthenticationService;
import com.herramientas.api.dto.RegisteredUser;
import com.herramientas.api.dto.SaveUser;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
@PreAuthorize("hasAuthority('CREATE_USER')") 
public class AdminController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<RegisteredUser> registerUser(@RequestBody @Valid SaveUser saveUser) {
        RegisteredUser registeredUser = authenticationService.registerOneCustomer(saveUser);
        return ResponseEntity.status(201).body(registeredUser);
    }

    @GetMapping
    public ResponseEntity<List<RegisteredUser>> getAllUsers() {
        List<RegisteredUser> users = authenticationService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}