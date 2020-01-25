package com.portifolioapi.service;

import java.util.List;

import com.portifolioapi.DTO.UsuarioDTO;
import com.portifolioapi.model.Usuario;

public interface UsuarioService {
	
	public UsuarioDTO salvarUsuario(UsuarioDTO usuario);
	
	public List<Usuario> listarTodos();
	
	public void deletar(Long id);
	
	public void atualizar(UsuarioDTO usuario);

}
