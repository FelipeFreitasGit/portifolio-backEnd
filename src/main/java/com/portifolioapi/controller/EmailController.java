package com.portifolioapi.controller;

import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portifolioapi.model.Email;
import com.portifolioapi.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody Email email) throws AddressException {

		emailService.enviar(email.getNome(), email.getEmail(), email.getMessage());
		
		return ResponseEntity.status(HttpStatus.OK).body("E-mail enviado!");
	}

}
