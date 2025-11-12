package com.foursales.market.controller;

import com.foursales.market.model.UserLogin;
import com.foursales.market.model.auth.AuthenticationDTO;
import com.foursales.market.model.auth.LoginResponseDTO;
import com.foursales.market.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authMenager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO request) {
        Authentication usernamePassword = new UsernamePasswordAuthenticationToken(request.login(), request.password());

        Authentication auth = authMenager.authenticate(usernamePassword);
        String token = tokenService.generateToken((UserLogin) auth.getPrincipal());

        return ResponseEntity.ok().body(new LoginResponseDTO(token));
    }

}
