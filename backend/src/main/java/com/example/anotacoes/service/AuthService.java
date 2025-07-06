package com.example.anotacoes.service;

import com.example.anotacoes.entity.Usuario;
import com.example.anotacoes.repository.UsuarioRepository;
import com.example.anotacoes.web.dto.AuthLoginDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private UsuarioRepository usuarioRepository;

    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public ResponseEntity<Usuario> login(AuthLoginDto authLoginDto){
        Optional<Usuario> existente = usuarioRepository.findByLogin(authLoginDto.getLogin());
        if (existente.isPresent() && existente.get().getSenha().equals(authLoginDto.getSenha())){
            System.out.println(existente.get());
            return ResponseEntity.ok().body(existente.get());
        }
        return ResponseEntity.notFound().build();
    }
}
