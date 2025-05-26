package com.herramientas.api.dto;

import com.herramientas.api.persistence.utils.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateUser {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    private Role role;

    private String email;
    private String phone;
    private String password;
    private String repeatedPassword;

    public boolean isPasswordsMatch() {
        return password == null || password.equals(repeatedPassword);
    }

    // Getters y Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRepeatedPassword() { return repeatedPassword; }
    public void setRepeatedPassword(String repeatedPassword) { this.repeatedPassword = repeatedPassword; }
}
