package com.fila.acesso.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fila.acesso.model.FilaAcesso;
import com.fila.acesso.service.FilaAcessoService;

@RestController
@RequestMapping("/fila-acesso")
public class FilaAcessoController {
	
	final FilaAcessoService filaAcessoService;
	
	public FilaAcessoController(FilaAcessoService filaAcessoService) {
		this.filaAcessoService = filaAcessoService;
	}
	
	@GetMapping
	public ResponseEntity<List<FilaAcesso>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(filaAcessoService.findAll());
	}
}
