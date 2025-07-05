package com.example.anotacoes.web.controller;



import com.example.anotacoes.entity.Usuario;
import com.example.anotacoes.service.UsuarioService;
import com.example.anotacoes.web.dto.UsuarioCreateDto;
import com.example.anotacoes.web.dto.UsuarioResponseDto;
import com.example.anotacoes.web.mapper.UsuarioMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
       this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody UsuarioCreateDto usuarioCreateDto){
        Usuario usuario = usuarioService.save(UsuarioMapper.fromDto(usuarioCreateDto));
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usuario.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> buscarPorId(@PathVariable String id){
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok().body(UsuarioMapper.toDto(usuario));
    }
}
