package com.example.anotacoes.repository;

import com.example.anotacoes.entity.AnotacaoHistorico;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnotacaoHistoricoRepository extends MongoRepository<AnotacaoHistorico, String> {
    public long countByIdAnotacao(String id);
}
