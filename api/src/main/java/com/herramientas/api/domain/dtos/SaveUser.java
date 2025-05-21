package com.herramientas.api.domain.dtos;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class SaveUser implements Serializable{
    @NotBlank
    private String firstName;
    
    @NotBlank
    private String lastName;
    
    @Email
    @NotBlank
    private String email;
    
    @NotBlank
    @Size(min = 8, max = 20)
    private String password;
    
    @NotBlank
    private String repeatedPassword;
    
    @Pattern(regexp = "^[+]?[0-9]{10,15}$")
    private String phone;

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

    
}
