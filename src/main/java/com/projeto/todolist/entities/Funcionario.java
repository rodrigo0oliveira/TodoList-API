package com.projeto.todolist.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String cargo;
	
	@OneToMany(mappedBy = "funcionario")
	private List<Tarefa> listaTarefas = new ArrayList<>();
	
	public Funcionario() {
	}

	public Funcionario(Long id, String nome,String cargo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Tarefa> getListaTarefas(){
		return listaTarefas;
	}
	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(id, other.id);
	}

	
	
}
