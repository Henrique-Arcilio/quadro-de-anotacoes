package com.example.anotacoes.repository;

import com.example.anotacoes.entity.AnotacaoHistorico;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AnotacaoHistoricoRepository extends MongoRepository<AnotacaoHistorico, String> {
    public long countByIdAnotacao(String id);
    public List<AnotacaoHistorico> findAllByIdAnotacao(String id);
}
