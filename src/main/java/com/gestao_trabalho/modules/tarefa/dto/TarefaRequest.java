package com.gestao_trabalho.modules.tarefa.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TarefaRequest {

    private String titulo;

    private String descricao;

    private LocalDate prazo;

    private Integer duracao;

}
