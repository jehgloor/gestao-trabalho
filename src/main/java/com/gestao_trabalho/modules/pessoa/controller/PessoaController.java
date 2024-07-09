package com.gestao_trabalho.modules.pessoa.controller;

import com.gestao_trabalho.modules.pessoa.dto.PessoaFiltro;
import com.gestao_trabalho.modules.pessoa.dto.PessoaRequest;
import com.gestao_trabalho.modules.pessoa.dto.PessoaResponse;
import com.gestao_trabalho.modules.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @PostMapping
    public PessoaResponse save(@Validated @RequestBody PessoaRequest request) {
        return service.save(request);
    }

    @PutMapping("{id}")
    public PessoaResponse edit(@Validated @RequestBody PessoaRequest request, @PathVariable Integer id) {
        return service.edit(request, id);
    }

    @GetMapping
    public Page<PessoaResponse> findAll(PessoaFiltro filtro, Pageable page) {
        return service.findAll(filtro, page);
    }

    @GetMapping("/findSemPredicate")
    public List<PessoaResponse> findAllSemPredicate() {
        return service.findAllSemPredicate();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
