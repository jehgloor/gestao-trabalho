package com.gestao_trabalho.modules.departamento.controller;

import com.gestao_trabalho.modules.departamento.dto.DepartamentoRequest;
import com.gestao_trabalho.modules.departamento.model.Departamento;
import com.gestao_trabalho.modules.departamento.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoService service;

    @PostMapping
    public Departamento save(@RequestBody DepartamentoRequest request){
        return service.save(request);
    }
}
