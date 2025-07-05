package com.example.anotacoes.web.controller;

import com.example.anotacoes.entity.Anotacao;
import com.example.anotacoes.entity.Quadro;
import com.example.anotacoes.service.AnotacaoService;
import com.example.anotacoes.service.QuadroService;
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
    private final QuadroService quadroService;

    @PostMapping
    public ResponseEntity<Void> criar(@PathVariable String idQuadro, @RequestBody AnotacaoCreateDto anotacaoCreateDto){
        Anotacao anotacao = AnotacaoMapper.fromDto(anotacaoCreateDto);
        Quadro quadro = quadroService.findById(idQuadro);
        quadro.getAnotacoes().add(anotacao);
        quadroService.save(quadro);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(anotacao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnotacaoResponseDto> buscarPorId(@PathVariable String id){
        //Anotacao anotacao = anotacaoService.findById(id);
        return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id){
        //Anotacao anotacao = anotacaoService.findById(id);
        //anotacaoService.delete(anotacao);
        return ResponseEntity.noContent().build();
    }
}
