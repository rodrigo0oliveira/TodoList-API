package com.projeto.todolist.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.todolist.entities.Tarefa;
import com.projeto.todolist.repositories.FuncionarioRepository;
import com.projeto.todolist.repositories.TarefaRepository;

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
		Optional<Tarefa> tarefa = tarefaRepository.findById(id);
		return tarefa.get();
	}
	
	@SuppressWarnings("deprecation")
	public Set<Tarefa> findByFuncionario(Long id){
		Set<Tarefa> listaTarefa = funcionarioRepository.getById(id).getListaTarefas();
		return listaTarefa;
		
	}
	
	private void update(Tarefa entity,Tarefa tarefa) {
		entity.setName(tarefa.getName());
		entity.setDescricao(tarefa.getDescricao());
		entity.setTarefaStatus(tarefa.getTarefaStatus());
		entity.setFuncionario(tarefa.getFuncionario());
		entity.setDescricao(tarefa.getDescricao());
		
	}

}
