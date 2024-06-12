package com.projeto.todolist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projeto.todolist.entities.Funcionario;
import com.projeto.todolist.repositories.FuncionarioRepository;
import com.projeto.todolist.services.exceptions.IntegrityException;
import com.projeto.todolist.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		try {
			funcionarioRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new IntegrityException(e.getMessage());
		}
	}
	
	public Funcionario updateFuncionario(Long id,Funcionario funcionario) {
		try {
			Funcionario entity = funcionarioRepository.getReferenceById(id);
			update(entity,funcionario);
			return funcionarioRepository.save(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public Funcionario findById(Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		return funcionario.orElseThrow(()-> new ResourceNotFoundException(id)) ;
	}
	
	private void update(Funcionario entity, Funcionario funcionario) {
		entity.setNome(funcionario.getNome());
		entity.setCargo(funcionario.getCargo());
	}

}
