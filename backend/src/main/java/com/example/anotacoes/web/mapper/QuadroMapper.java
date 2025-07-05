package com.example.anotacoes.web.mapper;


import com.example.anotacoes.entity.Quadro;
import com.example.anotacoes.web.dto.QuadroCreateDto;
import com.example.anotacoes.web.dto.QuadroResponseDto;
import org.modelmapper.ModelMapper;

public class QuadroMapper {
    public static Quadro fromDto(QuadroCreateDto quadroCreateDto){
        return new ModelMapper().map(quadroCreateDto, Quadro.class);
    }

    public static QuadroResponseDto toDto(Quadro quadro){
        return new ModelMapper().map(quadro, QuadroResponseDto.class);
    }

}
