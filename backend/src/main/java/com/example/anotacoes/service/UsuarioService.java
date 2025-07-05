package com.example.anotacoes.service;

import com.example.anotacoes.entity.Anotacao;
import com.example.anotacoes.entity.Quadro;
import com.example.anotacoes.entity.Usuario;
import com.example.anotacoes.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    public final UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public Usuario findById(String id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O id informado não existe"));
    }

    public void delete(Usuario usuario) {
        usuarioRepository.deleteById(usuario.getId());
    }
}
