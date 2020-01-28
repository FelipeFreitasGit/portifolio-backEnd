package com.portifolioapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuariologin")
public class UsuarioLogin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;
	
	@Getter
	@Setter
	@NotNull(message = "usuário é obrigatório")
	private String usuarioLogin;
	
	@Getter
	@Setter
	@NotNull(message = "Senha é obrigatório")
	private String senha;
}