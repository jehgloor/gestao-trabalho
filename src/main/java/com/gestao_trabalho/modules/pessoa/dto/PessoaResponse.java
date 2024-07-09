package com.gestao_trabalho.modules.pessoa.dto;

import com.gestao_trabalho.modules.pessoa.model.Pessoa;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class PessoaResponse {

    private String nome;

    public static List<PessoaResponse> convertFrom(List<Pessoa> pessoas) {
        return pessoas.stream().map(p -> convertFrom(p)).toList();
    }

    public static PessoaResponse convertFrom(Pessoa pessoa) {
        return PessoaResponse.builder()
                .nome(pessoa.getNome())
                .build();
    }
}
