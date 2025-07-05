package com.example.anotacoes.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(value = "usuarios")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Usuario {
    @Id
    private String id;
    private String nome;
    private String login;
    private String senha;
    private List<String> quadros = new ArrayList<>();

}
