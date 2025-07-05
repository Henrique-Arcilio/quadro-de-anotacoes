package com.example.anotacoes.service;


import com.example.anotacoes.entity.Anotacao;
import com.example.anotacoes.entity.AnotacaoHistorico;
import com.example.anotacoes.repository.AnotacaoHistoricoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnotacaoHistoricoService {

    public final AnotacaoHistoricoRepository repository;

    @Transactional
    public AnotacaoHistorico save(AnotacaoHistorico historico){
        return repository.save(historico);
    }

    @Transactional(readOnly = true)
    public AnotacaoHistorico findById(String id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("O id informado não existe"));
    }

    @Transactional(readOnly = true)
    public List<AnotacaoHistorico> buscarVersoes(String id){
        return repository.findAllByIdAnotacao(id);
    }

    @Transactional(readOnly = true)
    public AnotacaoHistorico buscarUmaVersao(String idAnotacao, long versao){
        return repository.findByIdAnotacaoAndVersao(idAnotacao, versao)
                .orElseThrow(() -> new RuntimeException("A versão informada não existe"));
    }

    @Transactional(readOnly = true)
    public long calcularVersao(Anotacao anotacao){
        return repository.countByIdAnotacao(anotacao.getId()) + 1;
    }

    @Transactional
    public long deletarVersoesNovas(String idAnotacao, long versao){
        return repository.deleteByIdAnotacaoAndVersaoGreaterThan(idAnotacao, versao);
    }

}
