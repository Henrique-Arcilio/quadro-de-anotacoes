package com.example.anotacoes.service;

import com.example.anotacoes.entity.Quadro;
import com.example.anotacoes.entity.Usuario;
import com.example.anotacoes.repository.QuadroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QuadroService {
    private final QuadroRepository quadroRepository;

    @Transactional
    public Quadro save(Quadro quadro){
        quadro.setId(UUID.randomUUID().toString());
        return quadroRepository.save(quadro);
    }

    @Transactional(readOnly = true)
    public Quadro findById(String id){
        return quadroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O id informado não existe"));
    }
}
