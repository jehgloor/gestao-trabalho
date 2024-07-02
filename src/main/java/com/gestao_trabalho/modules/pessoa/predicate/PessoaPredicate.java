package com.gestao_trabalho.modules.pessoa.predicate;

import com.gestao_trabalho.config.page.PredicateBase;

import static com.gestao_trabalho.modules.pessoa.model.QPessoa.pessoa;
import static org.apache.logging.log4j.util.Strings.isNotEmpty;

public class PessoaPredicate extends PredicateBase {

    public PessoaPredicate comNome(String nome) {
        if(isNotEmpty(nome)) {
            builder.and(pessoa.nome.containsIgnoreCase(nome));
        }
        return this;
    }
}
