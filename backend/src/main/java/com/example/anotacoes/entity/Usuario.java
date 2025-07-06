package com.example.anotacoes.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(value = "usuarios")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Usuario {
    @Id
    private String id;
    private String nome;
    private String login;
    private String senha;
    private List<String> quadros = new ArrayList<>();

}
