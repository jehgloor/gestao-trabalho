package com.gestao_trabalho.modules.departamento.service;

import com.gestao_trabalho.modules.comum.exception.model.NotFoundException;
import com.gestao_trabalho.modules.departamento.dto.DepartamentoRequest;
import com.gestao_trabalho.modules.departamento.model.Departamento;
import com.gestao_trabalho.modules.departamento.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoService {

    @Autowired
    DepartamentoRepository repository;

    public Departamento getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("deparamento não encontrado"));
    }

    public Departamento save(DepartamentoRequest request) {
        var departamento = Departamento.convertFrom(request);
        return repository.save(departamento);
    }
}
