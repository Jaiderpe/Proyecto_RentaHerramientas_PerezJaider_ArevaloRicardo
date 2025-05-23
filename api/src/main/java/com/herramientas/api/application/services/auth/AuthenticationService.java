package com.herramientas.api.application.services.auth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.herramientas.api.application.services.UserService;
import com.herramientas.api.dto.AuthenticationRequest;
import com.herramientas.api.dto.AuthenticationResponse;
import com.herramientas.api.dto.RegisteredUser;
import com.herramientas.api.dto.SaveUser;
import com.herramientas.api.persistence.entity.User;

@Service
public class AuthenticationService {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    public RegisteredUser registerOneCustomer(SaveUser newUser) {
        User user = userService.registrOneCustomer(newUser);
        RegisteredUser userDto = new RegisteredUser();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole().name());
        String jwt = jwtService.generateToken(user, generateExtraClaims(user));
        userDto.setJwt(jwt);
        return userDto;
    }

    private Map<String, Object> generateExtraClaims(User user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", user.getFirstName());
        extraClaims.put("role", user.getRole().name());
        extraClaims.put("authorities", user.getAuthorities());
        return extraClaims;
    }

    public AuthenticationResponse login(AuthenticationRequest autRequest) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                autRequest.getUsername(), autRequest.getPassword()
        );
        authenticationManager.authenticate(authentication);
        UserDetails user = userService.findOneByUsername(autRequest.getUsername()).get();
        String jwt = jwtService.generateToken(user, generateExtraClaims((User) user));
        AuthenticationResponse authRsp = new AuthenticationResponse();
        authRsp.setJwt(jwt);
        return authRsp;
    }

    public List<RegisteredUser> getAllUsers() {
    return userService.findAll().stream()
            .map(user -> {
                RegisteredUser dto = new RegisteredUser();
                dto.setId(user.getId());
                dto.setFirstName(user.getFirstName());
                dto.setLastName(user.getLastName());
                dto.setEmail(user.getEmail());
                dto.setRole(user.getRole().name());
                return dto;
            })
            .toList();
}

    public boolean validateToken(String jwt) {
        try {
            jwtService.extractUsername(jwt);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}