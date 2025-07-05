package com.example.anotacoes.web.controller;

import com.example.anotacoes.entity.Anotacao;
import com.example.anotacoes.entity.AnotacaoHistorico;
import com.example.anotacoes.entity.Quadro;
import com.example.anotacoes.service.AnotacaoHistoricoService;
import com.example.anotacoes.service.QuadroService;
import com.example.anotacoes.web.dto.*;
import com.example.anotacoes.web.mapper.AnotacaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/usuarios/{idUsuario}/quadros/{idQuadro}/anotacoes")
@RequiredArgsConstructor
public class AnotacaoController {
    private final QuadroService quadroService;
    private final AnotacaoHistoricoService anotacaoHistoricoService;

    @PostMapping
    public ResponseEntity<Void> criar(@PathVariable String idQuadro, @RequestBody AnotacaoCreateDto anotacaoCreateDto){
        Quadro quadro = quadroService.findById(idQuadro);

        Anotacao anotacao = AnotacaoMapper.fromDto(anotacaoCreateDto);
        anotacao.setId(UUID.randomUUID().toString());
        quadro.getAnotacoes().add(anotacao);

        AnotacaoHistorico historico = AnotacaoMapper.toHistorico(anotacao);
        historico.setIdQuadro(quadro.getId());
        historico.setVersao(1);

        anotacaoHistoricoService.save(historico);
        quadroService.save(quadro);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(anotacao.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<AnotacaoResponseDto>> buscarTodasDoUsuario(@PathVariable String idQuadro){
        Quadro quadro = quadroService.findById(idQuadro);
        List<AnotacaoResponseDto> anotacoesResponseDto = AnotacaoMapper.getListaDto(quadro.getAnotacoes());
        return ResponseEntity.ok().body(anotacoesResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnotacaoResponseDto> buscarPorId(@PathVariable String idQuadro, @PathVariable String id){
        Quadro quadro = quadroService.findById(idQuadro);
        Anotacao anotacao = quadroService.buscarAnotacao(quadro, id);

        return ResponseEntity.ok().body(AnotacaoMapper.toDto(anotacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable String idQuadro, @PathVariable String id, @RequestBody AnotacaoUpdateDto anotacaoUpdateDto){
        Quadro quadro = quadroService.findById(idQuadro);
        Anotacao anotacao = quadroService.buscarAnotacao(quadro,id);

        AnotacaoMapper.updateFromDto(anotacaoUpdateDto, anotacao);
        AnotacaoHistorico historico = AnotacaoMapper.toHistorico(anotacao);
        historico.setIdQuadro(quadro.getId());
        long versao = anotacaoHistoricoService.calcularVersao(anotacao);
        historico.setVersao(versao);

        anotacaoHistoricoService.save(historico);
        quadroService.save(quadro);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String idQuadro, @PathVariable String id){
        Quadro quadro = quadroService.findById(idQuadro);
        List<Anotacao> anotacoes = quadro.getAnotacoes();
        anotacaoHistoricoService.deletarVersoesDaAnotacao(id);

        Anotacao anotacao = quadroService.buscarAnotacao(quadro, id);
        anotacoes.remove(anotacao);
        quadroService.save(quadro);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/versoes")
    public ResponseEntity<List<AnotacaoHistoricoResponseDto>> buscarVersoes(@PathVariable String id){
        List<AnotacaoHistorico> anotacaoHistoricos = anotacaoHistoricoService.buscarVersoes(id);
        List<AnotacaoHistoricoResponseDto> anotacaoResponseDtos = AnotacaoMapper.getListaVersoesDto(anotacaoHistoricos);
        return ResponseEntity.ok().body(anotacaoResponseDtos);
    }

    @PutMapping("{idAnotacao}/versoes/{versao}")
    public ResponseEntity<AnotacaoRollBackDto> voltarParaUmaVersão(@PathVariable String idQuadro, @PathVariable String idAnotacao, @PathVariable long versao){
        Quadro quadro = quadroService.findById(idQuadro);
        Anotacao anotacao = quadroService.buscarAnotacao(quadro, idAnotacao);
        AnotacaoHistorico versaoDoHistorico = anotacaoHistoricoService.buscarUmaVersao(idAnotacao, versao);

        long versoesDeletadas = 0;
        AnotacaoMapper.updateVersao(anotacao, versaoDoHistorico);
        versoesDeletadas = anotacaoHistoricoService.deletarVersoesNovas(idAnotacao, versao);
        quadroService.save(quadro);

        AnotacaoRollBackDto rollBackDto = new AnotacaoRollBackDto(versoesDeletadas);
        return ResponseEntity.ok().body(rollBackDto);
    }

}
