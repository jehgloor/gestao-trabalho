package com.gestao_trabalho.modules.pessoa.controller;

import com.gestao_trabalho.modules.pessoa.dto.PessoaRequest;
import com.gestao_trabalho.modules.pessoa.dto.PessoaResponse;
import com.gestao_trabalho.modules.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @PostMapping
    public PessoaResponse save(@Validated @RequestBody PessoaRequest request) {
        return service.save(request);
    }
}
