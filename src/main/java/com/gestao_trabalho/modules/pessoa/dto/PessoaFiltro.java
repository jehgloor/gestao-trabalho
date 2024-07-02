package com.gestao_trabalho.modules.pessoa.dto;

import com.gestao_trabalho.modules.pessoa.predicate.PessoaPredicate;

public class PessoaFiltro {


    private String nome;

    public PessoaPredicate toPredicate() {
        var pre = new PessoaPredicate();
        pre.comNome(nome);
        return pre;
    }
}
