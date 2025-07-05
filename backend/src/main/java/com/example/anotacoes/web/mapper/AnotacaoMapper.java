package com.example.anotacoes.web.mapper;

import com.example.anotacoes.entity.Anotacao;
import com.example.anotacoes.entity.AnotacaoHistorico;
import com.example.anotacoes.web.dto.AnotacaoCreateDto;
import com.example.anotacoes.web.dto.AnotacaoHistoricoResponseDto;
import com.example.anotacoes.web.dto.AnotacaoResponseDto;
import com.example.anotacoes.web.dto.AnotacaoUpdateDto;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class AnotacaoMapper {

    public static Anotacao fromDto(AnotacaoCreateDto anotacaoCreateDto){
        return new ModelMapper().map(anotacaoCreateDto, Anotacao.class);
    }

    public static void updateFromDto(AnotacaoUpdateDto anotacaoUpdateDto, Anotacao anotacao){
        if (anotacaoUpdateDto.getTitulo() != null) {
            anotacao.setTitulo(anotacaoUpdateDto.getTitulo());
        }

        if (anotacaoUpdateDto.getTexto() != null) {
            anotacao.setTexto(anotacaoUpdateDto.getTexto());
        }

        if (anotacaoUpdateDto.getTags() != null) {
            anotacao.setTags(anotacaoUpdateDto.getTags());
        }
    }

    public static Anotacao updateVersao(Anotacao anotacao, AnotacaoHistorico historico){
        anotacao.setTitulo(historico.getTitulo());
        anotacao.setTexto(historico.getTexto());
        anotacao.setTags(historico.getTags());
        return anotacao;
    }

    public static AnotacaoResponseDto toDto(Anotacao anotacao){
        return new ModelMapper().map(anotacao, AnotacaoResponseDto.class);
    }

    public static List<AnotacaoHistoricoResponseDto> getListaVersoesDto(List<AnotacaoHistorico> todoHistorico){
        List<AnotacaoHistoricoResponseDto> versoesAnotacao = new ArrayList<>();
        for(AnotacaoHistorico historico : todoHistorico){
            AnotacaoHistoricoResponseDto anotacaoResponseDto =  new ModelMapper().map(historico, AnotacaoHistoricoResponseDto.class);
            versoesAnotacao.add(anotacaoResponseDto);
        }
        return versoesAnotacao;
    }
    public static List<AnotacaoResponseDto> getListaDto(List<Anotacao> anotacoes){
        List<AnotacaoResponseDto> versoesAnotacao = new ArrayList<>();
        for(Anotacao anotacao : anotacoes ){
            AnotacaoResponseDto anotacaoResponseDto =  new ModelMapper().map(anotacao, AnotacaoResponseDto.class);
            versoesAnotacao.add(anotacaoResponseDto);
        }
        return versoesAnotacao;
    }

    public static AnotacaoHistorico toHistorico(Anotacao anotacao){
        AnotacaoHistorico historico = new ModelMapper().map(anotacao, AnotacaoHistorico.class);
        return historico;
    }
}
