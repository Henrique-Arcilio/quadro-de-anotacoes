package com.example.anotacoes.web.mapper;

import com.example.anotacoes.entity.Usuario;
import com.example.anotacoes.web.dto.UsuarioCreateDto;
import com.example.anotacoes.web.dto.UsuarioResponseDto;
import org.modelmapper.ModelMapper;

public class UsuarioMapper {

    public static Usuario fromDto(UsuarioCreateDto usuarioCreateDto){
        return new ModelMapper().map(usuarioCreateDto, Usuario.class);
    }

    public static UsuarioResponseDto toDto(Usuario usuario){
        return new ModelMapper().map(usuario, UsuarioResponseDto.class);
    }


}
