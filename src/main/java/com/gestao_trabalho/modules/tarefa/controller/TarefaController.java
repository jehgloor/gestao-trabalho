package com.gestao_trabalho.modules.tarefa.controller;

import com.gestao_trabalho.modules.tarefa.dto.TarefaRequest;
import com.gestao_trabalho.modules.tarefa.model.Tarefa;
import com.gestao_trabalho.modules.tarefa.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService service;

    @PostMapping
    public Tarefa save(@RequestBody TarefaRequest request) {
        return service.save(request);
    }
}
