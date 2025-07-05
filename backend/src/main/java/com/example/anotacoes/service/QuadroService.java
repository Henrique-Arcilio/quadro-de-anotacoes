package com.example.anotacoes.service;

import com.example.anotacoes.entity.Anotacao;
import com.example.anotacoes.entity.Quadro;
import com.example.anotacoes.entity.Usuario;
import com.example.anotacoes.repository.QuadroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class QuadroService {
    private final QuadroRepository quadroRepository;

    @Transactional
    public Quadro save(Quadro quadro){
        return quadroRepository.save(quadro);
    }

    @Transactional(readOnly = true)
    public Quadro findById(String id){
        return quadroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O id informado não existe"));
    }

    public Anotacao buscarAnotacao(Quadro quadro, String idAnotacao){
        List<Anotacao> anotacoes = quadro.getAnotacoes();
        for (Anotacao anotacao : anotacoes){
            if(anotacao.getId().equals(idAnotacao)){
                return anotacao;
            }
        }
        throw new RuntimeException("Esse id de anotação não existe ");

    }
}
