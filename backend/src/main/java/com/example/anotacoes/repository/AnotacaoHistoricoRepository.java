package com.example.anotacoes.repository;

import com.example.anotacoes.entity.AnotacaoHistorico;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AnotacaoHistoricoRepository extends MongoRepository<AnotacaoHistorico, String> {
    long countByIdAnotacao(String id);
    List<AnotacaoHistorico> findAllByIdAnotacao(String id);
    Optional<AnotacaoHistorico> findByIdAnotacaoAndVersao(String id, long versao);
    long deleteByIdAnotacaoAndVersaoGreaterThan(String idAnotacao, long versao);
    void deleteByIdAnotacao(String idAnotacao);
}
