package com.portifolioapi.service;

import java.util.List;

import com.portifolioapi.DTO.UsuarioLoginDTO;
import com.portifolioapi.model.UsuarioLogin;

public interface LoginService {
	
	public List<UsuarioLogin> listarTodos();
	
	public UsuarioLogin salvar(UsuarioLoginDTO usuarioLogin);
	
	public void atualizar(UsuarioLoginDTO usuarioLogin);
	
	public void deletar(Long id);
}
