package com.gestao_trabalho.modules.pessoa.service;

import com.gestao_trabalho.modules.comum.exception.model.NotFoundException;
import com.gestao_trabalho.modules.pessoa.dto.PessoaFiltro;
import com.gestao_trabalho.modules.pessoa.dto.PessoaRequest;
import com.gestao_trabalho.modules.pessoa.dto.PessoaResponse;
import com.gestao_trabalho.modules.pessoa.model.Pessoa;
import com.gestao_trabalho.modules.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public PessoaResponse edit(PessoaRequest request, Integer id) {
        var pessoa = findById(id);
        pessoa.setNome(request.getNome());
        return PessoaResponse.convertFrom(pessoaRepository.save(pessoa));
    }

    private Pessoa findById(Integer id) {
        return pessoaRepository.findById(1).orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));
    }

    public Page<Pessoa> findAll(PessoaFiltro filtro, Pageable page) {
        var pessoa = filtro.toPredicate().build();
        return pessoaRepository.findAll(pessoa, page);
    }
}
