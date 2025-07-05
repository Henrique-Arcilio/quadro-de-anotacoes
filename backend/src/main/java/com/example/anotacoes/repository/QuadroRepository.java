package com.example.anotacoes.repository;

import com.example.anotacoes.entity.Quadro;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuadroRepository extends MongoRepository<Quadro, String> {
}
