package com.projeto.todolist.enums;

public enum TarefaStatus {
	
	PENDENTE(1),
	ANDAMENTO(2),
	CONCLUIDA(3);

	private int code;
	
	private TarefaStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static TarefaStatus valueOf(int code) {
		for (TarefaStatus value : TarefaStatus.values()){
			if(value.getCode()==code) {
				return value;
			}
		}
		throw new IllegalArgumentException();
	}

}
