package com.sheila.usuario.controller;

import javax.validation.Valid;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sheila.usuario.dto.UsuarioDto;
import com.sheila.usuario.model.Usuario;
import com.sheila.usuario.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuario")
public class UsuarioController {

	final UsuarioService usuarioService;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping
	public ResponseEntity<Object> saveUsuario(@RequestBody @Valid UsuarioDto usuarionDto)
			throws JsonProcessingException {

		var usuarioModel = new Usuario();
		BeanUtils.copyProperties(usuarionDto, usuarioModel);
		String rountingKey = "usuario";

		String usuarioJson = objectMapper.writeValueAsString(usuarionDto);

		Message message = MessageBuilder.withBody(usuarioJson.getBytes())
				.setContentType(MessageProperties.CONTENT_TYPE_JSON).build();

		rabbitTemplate.convertAndSend(rountingKey, message);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuarioModel));

	}

}