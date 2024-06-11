package com.projeto.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.todolist.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

}
