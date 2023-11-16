package com.gps.api.aula;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroAula(
        @NotBlank
        String titulo,
        @NotBlank
        String descricao,
        @NotBlank
        String link,
        @NotBlank
        String imagem,
        @NotNull
        Categoria categoria
) {
}
