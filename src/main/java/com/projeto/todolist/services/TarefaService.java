package com.projeto.todolist.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projeto.todolist.entities.Tarefa;
import com.projeto.todolist.repositories.FuncionarioRepository;
import com.projeto.todolist.repositories.TarefaRepository;
import com.projeto.todolist.services.exceptions.IntegrityException;
import com.projeto.todolist.services.exceptions.ResourceNotFoundException;

@Service
public class TarefaService {
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public Tarefa insert(Tarefa tarefa ){
		return tarefaRepository.save(tarefa);
	}
	
	public void deleteById(Long id) {
		try {
			tarefaRepository.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new IntegrityException(e.getMessage());
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
}
	
	public Tarefa updateTarefa(Long id,Tarefa tarefa) {
		try {
			Tarefa entity = tarefaRepository.getReferenceById(id);
			update(entity, tarefa);
			return tarefaRepository.save(entity);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public List<Tarefa> findAll(){
		return tarefaRepository.findAll();
	}
	
	public Tarefa findById(Long id) {
		Optional<Tarefa> tarefa = tarefaRepository.findById(id);
		return tarefa.orElseThrow(()-> new ResourceNotFoundException(id));	
}
	
	
	public List<Tarefa> findByFuncionario(Long id){
		List<Tarefa> listaTarefa = funcionarioRepository.getReferenceById(id).getListaTarefas();
		return listaTarefa;
		
	}
	
	private void update(Tarefa entity,Tarefa tarefa) {
		entity.setName(tarefa.getName());
		entity.setDescricao(tarefa.getDescricao());
		entity.setFuncionario(tarefa.getFuncionario());
		entity.setDescricao(tarefa.getDescricao());
		entity.setDataVencimento(tarefa.getDataVencimento());
		
	}

}
