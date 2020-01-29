package com.portifolioapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.portifolioapi.model.UsuarioLogin;

public interface LoginRepository extends JpaRepository<UsuarioLogin, Long>{
	
	@Transactional(readOnly=true)
	UsuarioLogin findByUsuarioLogin(String usuarioLogin);
}
