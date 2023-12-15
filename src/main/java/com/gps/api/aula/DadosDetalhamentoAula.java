package com.gps.api.aula;

public record DadosDetalhamentoAula(Long id, String titulo, String descricao, String link, String imagem, Categoria categoria) {
    public DadosDetalhamentoAula(Aula aula) {
        this(aula.getId(), aula.getTitulo(), aula.getDescricao(), aula.getLink(), aula.getImagem(), aula.getCategoria());
    }
}
