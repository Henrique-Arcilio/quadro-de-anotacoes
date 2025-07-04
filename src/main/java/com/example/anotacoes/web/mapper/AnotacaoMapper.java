package com.example.anotacoes.web.mapper;

import com.example.anotacoes.entity.Anotacao;
import com.example.anotacoes.web.dto.AnotacaoCreateDto;
import com.example.anotacoes.web.dto.AnotacaoResponseDto;
import org.modelmapper.ModelMapper;

public class AnotacaoMapper {
    public static Anotacao fromDto(AnotacaoCreateDto anotacaoCreateDto){
        return new ModelMapper().map(anotacaoCreateDto, Anotacao.class);
    }

    public static AnotacaoResponseDto toDto(Anotacao anotacao){
        return new ModelMapper().map(anotacao, AnotacaoResponseDto.class);
    }
}
