package com.projeto.todolist.services.exceptions;

public class IntegrityException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public IntegrityException(String msg) {
		super("Violação de integridade!Não é possível deletar.");
	}

}
