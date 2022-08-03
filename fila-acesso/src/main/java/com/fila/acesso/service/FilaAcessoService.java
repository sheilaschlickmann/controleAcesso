package com.fila.acesso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fila.acesso.model.FilaAcesso;
import com.fila.acesso.repository.FilaAcessoRepository;

@Service
public class FilaAcessoService {
	
	final FilaAcessoRepository filaAcessoRepository;

	public FilaAcessoService(FilaAcessoRepository filaAcessoRepository) {
		this.filaAcessoRepository = filaAcessoRepository;
	}

	//@Transactional
	public FilaAcesso save(FilaAcesso filaAcessoModel) {
		return filaAcessoRepository.save(filaAcessoModel);
	}
	
	public List<FilaAcesso> findAll() {
		return filaAcessoRepository.findAll();
	}
}
