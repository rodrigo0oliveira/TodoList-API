package com.projeto.todolist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.todolist.entities.Funcionario;
import com.projeto.todolist.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public List<Funcionario> findAll(){
		return funcionarioRepository.findAll();
	}
	
	public Funcionario insert(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	public void deleteById(Long id) {
		funcionarioRepository.deleteById(id);
	}
	
	public Funcionario updateFuncionario(Long id,Funcionario funcionario) {
		Funcionario entity = funcionarioRepository.getReferenceById(id);
		update(entity,funcionario);
		return funcionarioRepository.save(entity);
	}
	
	public Funcionario findById(Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		return funcionario.get();
	}
	
	private void update(Funcionario entity, Funcionario funcionario) {
		entity.setNome(funcionario.getNome());
		entity.setCargo(funcionario.getCargo());
	}

}
