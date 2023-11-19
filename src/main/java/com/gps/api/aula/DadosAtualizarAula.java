package com.gps.api.aula;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarAula(
        @NotNull
        Long id,
        String titulo,
        String descricao,
        String link,
        String imagem,
        Categoria categoria
) {
}
