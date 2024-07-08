package com.gestao_trabalho.modules.tarefa.service;

import com.gestao_trabalho.modules.tarefa.dto.TarefaRequest;
import com.gestao_trabalho.modules.tarefa.model.Tarefa;
import com.gestao_trabalho.modules.tarefa.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {

    @Autowired
    TarefaRepository repository;

    public Tarefa save(TarefaRequest request) {
        var tarefa = Tarefa.convertFrom(request);
        return repository.save(tarefa);
    }
}
