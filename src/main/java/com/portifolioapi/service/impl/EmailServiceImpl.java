package com.portifolioapi.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.portifolioapi.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private JavaMailSender mailSender;
	
	private static final Logger LOG = LoggerFactory.getLogger(EmailService.class);
	
	@Value("${spring.mail.username}")
	private String emailOrigem;

	@Override
	public void enviar(String nome, String email, String mensagem) {
		
		SimpleMailMessage emailMessage = new SimpleMailMessage();
		
		emailMessage.setTo(emailOrigem);
		emailMessage.setSubject("Enviado pelo portifolio por " + nome);
		emailMessage.setText(mensagem + "\n" + "E-mail: " + email);
		
		try {
			
			LOG.info("Enviando email...");
			mailSender.send(emailMessage);
			LOG.info("Email enviado!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
