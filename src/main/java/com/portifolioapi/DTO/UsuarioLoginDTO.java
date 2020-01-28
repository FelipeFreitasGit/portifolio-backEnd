package com.portifolioapi.DTO;

import lombok.Getter;
import lombok.Setter;

public class UsuarioLoginDTO {

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private String usuarioLogin;

	@Getter
	@Setter
	private String senha;
}
