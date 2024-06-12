package com.projeto.todolist.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projeto.todolist.entities.Funcionario;
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
		
		
		                                   
	}

}
