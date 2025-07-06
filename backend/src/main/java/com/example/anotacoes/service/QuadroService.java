package com.example.anotacoes.service;

import com.example.anotacoes.entity.Anotacao;
import com.example.anotacoes.entity.Quadro;
import com.example.anotacoes.entity.Usuario;
import com.example.anotacoes.repository.QuadroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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

    public List<Quadro> buscar(Usuario usuario){
        List<String> idQuadros = usuario.getQuadros();
        List<Quadro> quadros = new ArrayList<>();

        for (String id : idQuadros) {
            Optional<Quadro> quadro = quadroRepository.findById(id);
            if (quadro.isPresent()){
                quadros.add(quadro.get());
            }
        }

        return quadros;
    }
}
