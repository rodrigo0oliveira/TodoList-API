package com.projeto.todolist.config;

import java.time.Instant;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projeto.todolist.entities.Funcionario;
import com.projeto.todolist.entities.Tarefa;
import com.projeto.todolist.repositories.FuncionarioRepository;
import com.projeto.todolist.repositories.TarefaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public void run(String... args) throws Exception {
	
		
		Funcionario func1 = new Funcionario(null,"Rodrigo","Dev");
		Funcionario func2 = new Funcionario(null,"João","CEO");
		Funcionario func3 = new Funcionario(null,"Maria","Gerente");
		
		funcionarioRepository.saveAll(Arrays.asList(func1,func2,func3));
		
	
		
		Tarefa t1 = new Tarefa(null,"Projeto","Criar api",Instant.parse("2024-06-20T23:59:07Z"),func1);
		Tarefa t2 = new Tarefa(null,"Criar projetos","Criar projetos e repassar para os desenvolvedor",Instant.parse("2025-06-20T19:53:07Z"),func2);
		Tarefa t3 = new Tarefa(null,"Gerenciar","Gerenciar tarefas dos funcionários",Instant.parse("2026-09-20T20:53:07Z"),func3);
		
		tarefaRepository.saveAll(Arrays.asList(t1,t2,t3));
		                                   
	}

}
