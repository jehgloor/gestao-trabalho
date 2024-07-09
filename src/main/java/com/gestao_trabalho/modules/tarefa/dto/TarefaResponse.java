package com.gestao_trabalho.modules.tarefa.dto;

import com.gestao_trabalho.modules.tarefa.model.Tarefa;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TarefaResponse {

    private String titulo;

    private String descricao;

    private LocalDate prazo;

    private Integer duracao;

    private boolean finalizado;

    private Integer pessoaId;

    public static TarefaResponse convertFrom(Tarefa tarefa) {
        return TarefaResponse.builder()
                .titulo(tarefa.getTitulo())
                .descricao(tarefa.getDescricao())
                .prazo(tarefa.getPrazo())
                .duracao(tarefa.getDuracao())
                .finalizado(tarefa.isFinalizado())
                .pessoaId(tarefa.getPessoa() != null ? tarefa.getPessoa().getId() : null)
                .build();
    }
}
