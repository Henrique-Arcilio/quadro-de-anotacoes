package com.example.anotacoes.repository;

import com.example.anotacoes.entity.Anotacao;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AnotacaoRepository extends MongoRepository<Anotacao, String> {

}
