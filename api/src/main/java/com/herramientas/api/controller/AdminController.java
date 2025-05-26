package com.herramientas.api.controller;

import com.herramientas.api.application.services.UserService;
import com.herramientas.api.dto.RegisteredUser;
import com.herramientas.api.dto.SaveUser;
import com.herramientas.api.dto.UpdateUser;
import com.herramientas.api.persistence.entity.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/users")
@PreAuthorize("hasAuthority('READ_ALL_USERS')")
public class AdminController {

    @Autowired
    private UserService userService;

    @PostMapping
    @PreAuthorize("hasAuthority('CREATE_USER')")
    public ResponseEntity<RegisteredUser> createUser(@RequestBody @Valid SaveUser saveUser) {
        User user = userService.registrOneCustomer(saveUser);
        return ResponseEntity.status(201).body(RegisteredUser.from(user));
    }

    @GetMapping
    public ResponseEntity<List<RegisteredUser>> getAllUsers() {
        List<User> users = userService.findAll();
        List<RegisteredUser> result = users.stream().map(RegisteredUser::from).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegisteredUser> getUser(@PathVariable Long id) {
        User user = userService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con ID: " + id));
        return ResponseEntity.ok(RegisteredUser.from(user));
    }

    @PutMapping("/{id}")
public ResponseEntity<RegisteredUser> updateUser(
        @PathVariable Long id,
        @RequestBody @Valid UpdateUser dto) {

    User updated = userService.updateUser(id, dto);
    return ResponseEntity.ok(RegisteredUser.from(updated));
}


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_USER')")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}