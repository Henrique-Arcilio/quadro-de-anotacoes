package com.example.anotacoes.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "quadros")
public class Quadro {
    @Id
    private String id;
    private String titulo;
    private List<Anotacao> anotacoes = new ArrayList<>();
}
