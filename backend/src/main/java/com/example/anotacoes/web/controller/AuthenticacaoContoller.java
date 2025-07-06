package com.example.anotacoes.web.controller;


import com.example.anotacoes.entity.Usuario;
import com.example.anotacoes.service.AuthService;
import com.example.anotacoes.web.dto.AuthLoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticacaoContoller {
    private final AuthService authService;

    @PostMapping
    public ResponseEntity<Usuario> login(@RequestBody AuthLoginDto loginDto){
        return authService.login(loginDto);
    }
}
