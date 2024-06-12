package com.projeto.todolist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.todolist.entities.Tarefa;
import com.projeto.todolist.repositories.TarefaRepository;

@Service
public class TarefaService {
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	public Tarefa insert(Tarefa tarefa ){
		return tarefaRepository.save(tarefa);
	}
	
	public void deleteById(Long id) {
		tarefaRepository.deleteById(id);
	}
	
	public Tarefa updateTarefa(Long id,Tarefa tarefa) {
		Tarefa entity = tarefaRepository.getReferenceById(id);
		update(entity, tarefa);
		return tarefaRepository.save(entity);
	}
	
	public List<Tarefa> findAll(){
		return tarefaRepository.findAll();
	}
	
	public Tarefa findById(Long id) {
		Optional<Tarefa> user = tarefaRepository.findById(id);
		return user.get();
	}
	
	private void update(Tarefa entity,Tarefa tarefa) {
		entity.setName(tarefa.getName());
		entity.setDescricao(tarefa.getDescricao());
		entity.setTarefaStatus(tarefa.getTarefaStatus());
		entity.setFuncionario(tarefa.getFuncionario());
		entity.setDescricao(tarefa.getDescricao());
		
	}

}
