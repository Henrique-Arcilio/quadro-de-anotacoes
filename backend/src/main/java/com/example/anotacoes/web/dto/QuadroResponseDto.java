package com.example.anotacoes.web.dto;

import com.example.anotacoes.entity.Anotacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuadroResponseDto {
    private String id;
    public String titulo;
    public List<Anotacao> anotacoes;
}
