package com.gestao_trabalho.modules.pessoa.service;

import com.gestao_trabalho.modules.comum.exception.model.NotFoundException;
import com.gestao_trabalho.modules.departamento.service.DepartamentoService;
import com.gestao_trabalho.modules.pessoa.dto.PessoaFiltro;
import com.gestao_trabalho.modules.pessoa.dto.PessoaRequest;
import com.gestao_trabalho.modules.pessoa.dto.PessoaResponse;
import com.gestao_trabalho.modules.pessoa.model.Pessoa;
import com.gestao_trabalho.modules.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    DepartamentoService departamentoService;

    public PessoaResponse save(PessoaRequest request) {
        var departamento = departamentoService.getById(request.getDepartamentoId());
        var pessoa = Pessoa.convertFrom(request, departamento);
        var pessoaSalva = pessoaRepository.save(pessoa);
        return PessoaResponse.convertFrom(pessoaSalva);
    }

    public PessoaResponse edit(PessoaRequest request, Integer id) {
        var pessoa = findById(id);
        pessoa.editAll(request);
        return PessoaResponse.convertFrom(pessoaRepository.save(pessoa));
    }

    public Pessoa findById(Integer id) {
        return pessoaRepository.findById(1).orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));
    }

    public Page<PessoaResponse> findAll(PessoaFiltro filtro, Pageable page) {
        return pessoaRepository.findAll(filtro.toPredicate().build(), page)
                .map(PessoaResponse::convertFrom);
    }

    public List<PessoaResponse> findAllSemPredicate() {
        return PessoaResponse.convertFrom(pessoaRepository.findAll());
    }

    public void delete(Integer id) {
        var pessoa = findById(id);
        pessoaRepository.delete(pessoa);
    }
}
