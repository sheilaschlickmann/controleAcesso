package com.sheila.usuario.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sheila.usuario.model.Usuario;
import com.sheila.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {

	final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Transactional
	public Usuario save(Usuario usuarioModel) {
		return usuarioRepository.save(usuarioModel);
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

}
