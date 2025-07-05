package com.example.anotacoes.web.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnotacaoHistoricoResponseDto {
    private String titulo;
    private String texto;
    private List<String> tags;
    private long versao;
}
