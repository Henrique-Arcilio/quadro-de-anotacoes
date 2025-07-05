package com.example.anotacoes.service;

import com.example.anotacoes.entity.Usuario;
import com.example.anotacoes.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
    @Transactional
    public void delete(Usuario usuario) {
        usuarioRepository.deleteById(usuario.getId());
    }
}
