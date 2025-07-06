package com.example.anotacoes.repository;


import com.example.anotacoes.entity.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository  extends MongoRepository<Usuario, String> {
    Optional<Usuario> findByLogin(String login);
}
