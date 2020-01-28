package com.portifolioapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portifolioapi.DTO.UsuarioLoginDTO;
import com.portifolioapi.model.UsuarioLogin;
import com.portifolioapi.repository.LoginRepository;
import com.portifolioapi.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
//	@Autowired
//	private BCryptPasswordEncoder bcrypt;

	@Override
	public List<UsuarioLogin> listarTodos() {
		return loginRepository.findAll();
	}

	@Override
	public UsuarioLogin salvar(UsuarioLoginDTO usuarioLoginDTO) {
		//usuarioLogin.setSenha(bcrypt.encode(usuarioLogin.getSenha()));
		UsuarioLogin usuarioLogin = new UsuarioLogin();
		
		usuarioLogin.setUsuarioLogin(usuarioLoginDTO.getUsuarioLogin());
		usuarioLogin.setSenha(usuarioLoginDTO.getSenha());

		return loginRepository.save(usuarioLogin);
	}

	@Override
	public void atualizar(UsuarioLoginDTO usuarioLogin) {
		
		loginRepository.findById(usuarioLogin.getId()).map(login -> {
			
			login.setUsuarioLogin(usuarioLogin.getUsuarioLogin());
			login.setSenha(usuarioLogin.getSenha());

			return loginRepository.save(login);
		});
	}

	@Override
	public void deletar(Long id) {
		loginRepository.deleteById(id);
	}

}
