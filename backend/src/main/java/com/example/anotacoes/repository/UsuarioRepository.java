package com.example.anotacoes.repository;


import com.example.anotacoes.entity.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository  extends MongoRepository<Usuario, String> {
}
