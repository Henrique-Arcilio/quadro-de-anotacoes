package com.example.anotacoes.service;

import com.example.anotacoes.entity.Anotacao;
import com.example.anotacoes.entity.Usuario;
import com.example.anotacoes.repository.AnotacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AnotacaoService {

    private final AnotacaoRepository repository;

    @Transactional
    public Anotacao save(Anotacao anotacao){
        return repository.save(anotacao);
    }

    @Transactional(readOnly = true)
    public Anotacao findById(String id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("O id informado não existe"));
    }

    public void delete(Anotacao anotacao) {
        repository.deleteById(anotacao.getId());
    }


}
