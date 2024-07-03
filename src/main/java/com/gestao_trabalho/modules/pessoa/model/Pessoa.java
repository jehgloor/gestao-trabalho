package com.gestao_trabalho.modules.pessoa.model;

import com.gestao_trabalho.modules.pessoa.dto.PessoaRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public static Pessoa convertFrom(PessoaRequest request) {
        return Pessoa.builder()
                .nome(request.getNome())
                .build();
    }

    public void editAll(PessoaRequest request) {
        this.nome = request.getNome();
    }
}
