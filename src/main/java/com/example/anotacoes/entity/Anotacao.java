package com.example.anotacoes.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(value = "anotacoes")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Anotacao {
    @Id
    private String id;
    private String titulo;
    private String texto;
    private List<String> tags;
}
