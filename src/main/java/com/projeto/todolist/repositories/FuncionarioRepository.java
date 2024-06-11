package com.projeto.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.todolist.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
