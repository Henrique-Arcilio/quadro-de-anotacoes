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
        Anotacao anotacao = AnotacaoMapper.fromDto(anotacaoCreateDto);
        anotacao.setId(UUID.randomUUID().toString());
        Quadro quadro = quadroService.findById(idQuadro);
        quadro.getAnotacoes().add(anotacao);

        AnotacaoHistorico historico = AnotacaoMapper.toHistorico(anotacao);
        historico.setIdQuadro(quadro.getId());
        historico.setVersao(1);
        anotacaoHistoricoService.save(historico);
        quadroService.save(quadro);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(anotacao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnotacaoResponseDto> buscarPorId(@PathVariable String id){
        //Anotacao anotacao = anotacaoService.findById(id);
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable String idQuadro,@PathVariable String id, @RequestBody AnotacaoUpdateDto anotacaoUpdateDto){
        Quadro quadro = quadroService.findById(idQuadro);
        List<Anotacao> anotacoes = quadro.getAnotacoes();
        AnotacaoHistorico historico = null;
        for(Anotacao anotacao : anotacoes){
            if(anotacao.getId().equals(id)){
                AnotacaoMapper.updateFromDto(anotacaoUpdateDto, anotacao);
                historico = AnotacaoMapper.toHistorico(anotacao);
                historico.setIdQuadro(quadro.getId());
                long versao = anotacaoHistoricoService.calcularVersao(anotacao);
                historico.setVersao(versao);
                anotacaoHistoricoService.save(historico);
                quadroService.save(quadro);
                break;
            }
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id){
        //Anotacao anotacao = anotacaoService.findById(id);
        //anotacaoService.delete(anotacao);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/versoes")
    public ResponseEntity<List<AnotacaoHistoricoResponseDto>> buscarVersoes(@PathVariable String id){
        List<AnotacaoHistorico> anotacaoHistoricos = anotacaoHistoricoService.buscarVersoes(id);
        List<AnotacaoHistoricoResponseDto> anotacaoResponseDtos = AnotacaoMapper.getAllVersions(anotacaoHistoricos);
        return ResponseEntity.ok().body(anotacaoResponseDtos);
    }

    @PutMapping("{idAnotacao}/versoes/{versao}")
    public ResponseEntity<AnotacaoRollBackDto> voltarParaUmaVersão(@PathVariable String idQuadro, @PathVariable String idAnotacao, @PathVariable long versao){
        Quadro quadro = quadroService.findById(idQuadro);
        AnotacaoHistorico versaoDoHistorico = anotacaoHistoricoService.buscarUmaVersao(idAnotacao, versao);
        long versoesDeletadas = 0;
        for(Anotacao anotacao : quadro.getAnotacoes()){
            if(anotacao.getId().equals(idAnotacao)){
                AnotacaoMapper.updateVersao(anotacao, versaoDoHistorico);
                versoesDeletadas = anotacaoHistoricoService.deletarVersoesNovas(idAnotacao, versao);
                quadroService.save(quadro);
                break;
            }
        }
        AnotacaoRollBackDto rollBackDto = new AnotacaoRollBackDto(versoesDeletadas);
        return ResponseEntity.ok().body(rollBackDto);
    }

}
