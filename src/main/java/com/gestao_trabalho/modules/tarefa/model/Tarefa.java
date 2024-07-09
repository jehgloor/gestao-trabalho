package com.gestao_trabalho.modules.tarefa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestao_trabalho.modules.pessoa.model.Pessoa;
import com.gestao_trabalho.modules.tarefa.dto.TarefaRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "TAREFA")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "PRAZO")
    private LocalDate prazo;

    @Column(name = "DURACAO")
    private Integer duracao;

    @Column(name = "FINALIZADO")
    private boolean finalizado;

    @ManyToOne
    @JsonIgnore
    private Pessoa pessoa;

    public static Tarefa convertFrom(TarefaRequest request) {
        return Tarefa.builder()
                .titulo(request.getTitulo())
                .descricao(request.getDescricao())
                .prazo(request.getPrazo())
                .duracao(request.getDuracao())
                .finalizado(false)
                .build();
    }
}
