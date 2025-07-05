package com.example.anotacoes.entity;


 import lombok.AllArgsConstructor;
 import lombok.Getter;
 import lombok.NoArgsConstructor;
 import lombok.Setter;
 import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("versoes")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AnotacaoHistorico {
    private String idAnotacao;
    private String idQuadro;
    private String titulo;
    private String texto;
    private List<String> tags;
    private long versao;
}
