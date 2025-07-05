package com.example.anotacoes.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AnotacaoUpdateDto {
    private String titulo;
    private String texto;
    private List<String> tags;
}
