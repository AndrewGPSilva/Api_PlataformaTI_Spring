package com.gps.api.aula;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "aulas")
@Entity(name = "Aula")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aula {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    private String link;

    private String imagem;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Aula(DadosCadastroAula dados) {
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.link = dados.link();
        this.imagem = dados.imagem();
        this.categoria = dados.categoria();
    }
}
