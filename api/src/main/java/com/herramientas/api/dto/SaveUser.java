package com.herramientas.api.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;

public class SaveUser implements Serializable {

    @NotBlank(message = "Nombre es requerido")
    private String firstName;

    @NotBlank(message = "Apellido es requerido")
    private String lastName;

    @Email(message = "Correo inválido")
    @NotBlank(message = "Correo es requerido")
    private String email;

    @NotBlank(message = "Contraseña es requerida")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String password;

    @NotBlank(message = "Repetir contraseña es requerido")
    private String repeatedPassword;

    
    private String phone;

    private String role; 

    @AssertTrue(message = "Las contraseñas no coinciden")
    public boolean isPasswordsMatch() {
        return password != null && password.equals(repeatedPassword);
    }

    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Asignar ROLE_CUSTOMER por defecto
    public String getRole() {
        return (role == null) ? "ROLE_CUSTOMER" : role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
}