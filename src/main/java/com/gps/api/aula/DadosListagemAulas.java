package com.gps.api.aula;

public record DadosListagemAulas(
    String titulo,
    String descricao,
    String link,
    String imagem,
    Categoria categoria
) {
    public DadosListagemAulas(Aula aula){
        this(aula.getTitulo(), aula.getDescricao(), aula.getLink(), aula.getImagem(), aula.getCategoria());
    }     
}
