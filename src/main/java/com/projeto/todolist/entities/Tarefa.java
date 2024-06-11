package com.projeto.todolist.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import com.projeto.todolist.enums.TarefaStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tarefa")
public class Tarefa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String descricao;
	private Date dataVencimento;
	private Integer tarefaStatus;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;
	
	public Tarefa() {
	}

	public Tarefa(Long id, String name, String descricao, Date dataVencimento, Funcionario funcionario,TarefaStatus tarefaStatus) {
		super();
		this.id = id;
		this.name = name;
		this.descricao = descricao;
		this.dataVencimento = dataVencimento;
		this.funcionario = funcionario;
		setTarefaStatus(tarefaStatus);
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescricao() {
		return descricao;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public TarefaStatus getTarefaStatus() {
		return TarefaStatus.valueOf(tarefaStatus);
	}
	
	public void setTarefaStatus(TarefaStatus tarefaStatus) {
		if(tarefaStatus!=null) {
			this.tarefaStatus = tarefaStatus.getCode();
		}
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
		Tarefa other = (Tarefa) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
