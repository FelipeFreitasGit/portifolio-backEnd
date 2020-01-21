package com.portifolioapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portifolioapi.DTO.UsuarioDTO;
import com.portifolioapi.model.Usuario;
import com.portifolioapi.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService user;
	
	@GetMapping("/check")
	public ResponseEntity<?> check() {

		return ResponseEntity.status(HttpStatus.OK).body("codeHttp:" + HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listar() {

		return ResponseEntity.status(HttpStatus.OK).body(user.listarTodos());
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody UsuarioDTO usuario) {
		
		try {
			UsuarioDTO usuarioSalvo = user.salvarUsuario(usuario);
			
			return ResponseEntity.status(HttpStatus.CREATED).body("Curriculo cadastrado!");			
		} catch (Exception e) {
			return new ResponseEntity<>("Não foi possivel inserir usuário", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
