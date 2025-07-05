package com.example.anotacoes.web.controller;

import com.example.anotacoes.entity.Anotacao;
import com.example.anotacoes.service.AnotacaoService;
import com.example.anotacoes.web.dto.AnotacaoCreateDto;
import com.example.anotacoes.web.dto.AnotacaoResponseDto;
import com.example.anotacoes.web.mapper.AnotacaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/usuarios/{idUsuario}/quadros/{idQuadro}/anotacoes")
@RequiredArgsConstructor
public class AnotacaoController {
    private final AnotacaoService anotacaoService;

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody AnotacaoCreateDto anotacaoCreateDto){
        Anotacao anotacao = anotacaoService.save(AnotacaoMapper.fromDto(anotacaoCreateDto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(anotacao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnotacaoResponseDto> buscarPorId(@PathVariable String id){
        Anotacao anotacao = anotacaoService.findById(id);
        return ResponseEntity.ok().body(AnotacaoMapper.toDto(anotacao));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id){
        Anotacao anotacao = anotacaoService.findById(id);
        anotacaoService.delete(anotacao);
        return ResponseEntity.noContent().build();
    }
}
