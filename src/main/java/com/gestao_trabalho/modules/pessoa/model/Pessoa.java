package com.gestao_trabalho.modules.pessoa.model;

import com.gestao_trabalho.modules.pessoa.dto.PessoaRequest;
import com.gestao_trabalho.modules.tarefa.model.Tarefa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PESSOA")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @OneToMany(mappedBy = "pessoa")
    private List<Tarefa> tarefas;

    public static Pessoa convertFrom(PessoaRequest request) {
        return Pessoa.builder()
                .nome(request.getNome())
                .build();
    }

    public void editAll(PessoaRequest request) {
        this.nome = request.getNome();
    }
}
