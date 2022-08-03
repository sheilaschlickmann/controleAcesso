package com.fila.acesso.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fila.acesso.dto.FilaAcessoDto;
import com.fila.acesso.model.FilaAcesso;
import com.fila.acesso.service.FilaAcessoService;

@Component
public class FilaAcessoListener {
	
	final FilaAcessoService filaAcessoService;
	
	public FilaAcessoListener(FilaAcessoService filaAcessoService) {
		this.filaAcessoService = filaAcessoService;
	}
	
	
	@Bean
	public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	

	private static Logger logger = LoggerFactory.getLogger(FilaAcessoListener.class);

	@RabbitListener(queues = "usuario")
	public void listenUsuario(@Payload FilaAcessoDto filaacessoDto) {
		System.out.println(filaacessoDto);
		logger.info("Lendo fila usuario " + filaacessoDto);
		
		var filaAcesso = new FilaAcesso();
		BeanUtils.copyProperties(filaacessoDto, filaAcesso);
		
		filaAcessoService.save(filaAcesso);
		
		logger.info("salvando fila " + filaAcesso);

	}
	
	

}
