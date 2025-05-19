package com.herramientas.api.domain.dtos;

public class AuthenticationResponse {
    private String jwt;

    public String getjwt(){
        return jwt;
    }
    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
