package com.projeto.todolist.resources;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.todolist.entities.Tarefa;
import com.projeto.todolist.services.TarefaService;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefaResource {
	
	@Autowired
	private TarefaService tarefaService;
	
	@GetMapping
	public ResponseEntity<List<Tarefa>> findAll(){
		List<Tarefa> listaTarefa = tarefaService.findAll();
		return ResponseEntity.ok().body(listaTarefa);	
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Tarefa> findById(@PathVariable Long id){
		Tarefa tarefa = tarefaService.findById(id);
		return ResponseEntity.ok().body(tarefa);
	}
	
	
	@PostMapping
	public ResponseEntity<Tarefa> insert (@RequestBody Tarefa tarefa){
		tarefa = tarefaService.insert(tarefa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(tarefa.getId()).toUri();
		return ResponseEntity.created(uri).body(tarefa);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Tarefa> deleteById(@PathVariable Long id){
		tarefaService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Tarefa> update(@PathVariable Long id, @RequestBody Tarefa tarefa){
		tarefa = tarefaService.updateTarefa(id, tarefa);
		return ResponseEntity.ok().body(tarefa);
	}
}
