package com.gestao_trabalho.modules.tarefa.repository;

import com.gestao_trabalho.modules.tarefa.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer>, QuerydslPredicateExecutor<Tarefa> {
}
