package com.gestao_trabalho.modules.pessoa.dto;

import com.gestao_trabalho.modules.pessoa.model.Pessoa;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PessoaResponse {

    private String nome;

    public static PessoaResponse convertFrom(Pessoa pessoa) {
        return PessoaResponse.builder()
                .nome(pessoa.getNome())
                .build();
    }
}
