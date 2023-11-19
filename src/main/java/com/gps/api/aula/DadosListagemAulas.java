package com.gps.api.aula;

public record DadosListagemAulas(Long id,
    String titulo,
    String descricao,
    String link,
    String imagem,
    Categoria categoria
) {
    public DadosListagemAulas(Aula aula){
        this(aula.getId(), aula.getTitulo(), aula.getDescricao(), aula.getLink(), aula.getImagem(), aula.getCategoria());
    }     
}
