package com.projeto.todolist.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.projeto.todolist.services.exceptions.IntegrityException;
import com.projeto.todolist.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandartError> resourceNotFound(ResourceNotFoundException  e,HttpServletRequest request){
		String error = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandartError stardart = new StandartError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
		
		return ResponseEntity.status(status).body(stardart);
	}
	
	@ExceptionHandler(IntegrityException.class)
	public ResponseEntity<StandartError> integrityException(IntegrityException  e,HttpServletRequest request){
		String error = "Não é possível deletar";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandartError stardart = new StandartError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
		
		return ResponseEntity.status(status).body(stardart);
	}

}
