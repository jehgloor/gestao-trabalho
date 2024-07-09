package com.gestao_trabalho.modules.tarefa.service;

import com.gestao_trabalho.modules.comum.exception.model.NotFoundException;
import com.gestao_trabalho.modules.pessoa.service.PessoaService;
import com.gestao_trabalho.modules.tarefa.dto.AlocarPessoaRequest;
import com.gestao_trabalho.modules.tarefa.dto.TarefaRequest;
import com.gestao_trabalho.modules.tarefa.dto.TarefaResponse;
import com.gestao_trabalho.modules.tarefa.model.Tarefa;
import com.gestao_trabalho.modules.tarefa.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {

    @Autowired
    TarefaRepository repository;

    @Autowired
    PessoaService pessoaService;

    public Tarefa save(TarefaRequest request) {
        var tarefa = Tarefa.convertFrom(request);
        return repository.save(tarefa);
    }

    public TarefaResponse alocarPessoaNaTarefa(Integer tarefaId, AlocarPessoaRequest request) {
        var tarefa = getById(tarefaId);
        var pessoa = pessoaService.findById(request.getPessoaId());

        tarefa.setPessoa(pessoa);
        repository.save(tarefa);
        return TarefaResponse.convertFrom(tarefa);
    }

    private Tarefa getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tarefa não encontrado"));
    }
}
