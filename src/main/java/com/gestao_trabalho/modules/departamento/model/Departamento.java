package com.gestao_trabalho.modules.departamento.model;

import com.gestao_trabalho.modules.departamento.dto.DepartamentoRequest;
import com.gestao_trabalho.modules.pessoa.model.Pessoa;
import com.gestao_trabalho.modules.tarefa.model.Tarefa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "DEPARTAMENTO")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @OneToMany(mappedBy = "departamento")
    private List<Pessoa> pessoas;

    @OneToMany(mappedBy = "departamento")
    private List<Tarefa> tarefas;

    public static Departamento convertFrom(DepartamentoRequest request) {
        return Departamento.builder().nome(request.getNome()).build();
    }
}
