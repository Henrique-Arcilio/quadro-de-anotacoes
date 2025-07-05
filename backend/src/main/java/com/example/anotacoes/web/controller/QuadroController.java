package com.example.anotacoes.web.controller;

import com.example.anotacoes.entity.Quadro;
import com.example.anotacoes.entity.Usuario;
import com.example.anotacoes.service.QuadroService;
import com.example.anotacoes.service.UsuarioService;
import com.example.anotacoes.web.dto.QuadroCreateDto;
import com.example.anotacoes.web.dto.QuadroResponseDto;
import com.example.anotacoes.web.mapper.QuadroMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/usuarios/{idUsuario}/quadros")
@RequiredArgsConstructor
public class QuadroController {
    public final QuadroService quadroService;
    public final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> criar(@PathVariable String idUsuario, @RequestBody QuadroCreateDto quadroCreateDto){
        Quadro quadro = quadroService.save(QuadroMapper.fromDto(quadroCreateDto));
        Usuario usuario = usuarioService.findById(idUsuario);
        usuario.getQuadros().add(quadro.getId());
        usuarioService.save(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(quadro.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuadroResponseDto> buscarPorId(@PathVariable String id){
        Quadro quadro = quadroService.findById(id);
        return ResponseEntity.ok().body(QuadroMapper.toDto(quadro));
    }
}
