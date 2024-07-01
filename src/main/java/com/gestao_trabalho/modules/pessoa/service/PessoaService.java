package com.gestao_trabalho.modules.pessoa.service;

import com.gestao_trabalho.modules.pessoa.dto.PessoaRequest;
import com.gestao_trabalho.modules.pessoa.dto.PessoaResponse;
import com.gestao_trabalho.modules.pessoa.model.Pessoa;
import com.gestao_trabalho.modules.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public PessoaResponse save(PessoaRequest request) {
        var pessoa = Pessoa.convertFrom(request);
        var pessoaSalva = pessoaRepository.save(pessoa);
        return PessoaResponse.convertFrom(pessoaSalva);
    }
}
