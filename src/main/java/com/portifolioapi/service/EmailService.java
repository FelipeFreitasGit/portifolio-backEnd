package com.portifolioapi.service;

import org.springframework.scheduling.annotation.Async;

public interface EmailService {

	@Async
	public void enviar(String nome, String email, String mensagem);
}
