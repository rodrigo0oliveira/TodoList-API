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

import com.projeto.todolist.entities.Funcionario;
import com.projeto.todolist.services.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> findAll(){
		List<Funcionario> listaFuncionario = funcionarioService.findAll();
		return ResponseEntity.ok().body(listaFuncionario);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Funcionario> findById(@PathVariable Long id){
		Funcionario funcionario = funcionarioService.findById(id);
		return ResponseEntity.ok().body(funcionario);
	}
	
	@PostMapping
	public ResponseEntity<Funcionario> insert (@RequestBody Funcionario funcionario){
		funcionario = funcionarioService.insert(funcionario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(funcionario.getId()).toUri();
		return ResponseEntity.created(uri).body(funcionario);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Funcionario> update (@PathVariable Long id, @RequestBody Funcionario funcionario){
		funcionario = funcionarioService.updateFuncionario(id, funcionario);
		return ResponseEntity.ok().body(funcionario);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Funcionario> deleteById(@PathVariable Long id){
		funcionarioService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	

}
