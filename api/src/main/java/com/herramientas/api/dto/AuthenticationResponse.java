package com.herramientas.api.dto;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {
    private String jwt;

    public String getjwt(){
        return jwt;
    }
    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
