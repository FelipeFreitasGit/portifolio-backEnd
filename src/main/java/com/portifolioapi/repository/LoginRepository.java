package com.portifolioapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portifolioapi.model.UsuarioLogin;

public interface LoginRepository extends JpaRepository<UsuarioLogin, Long>{

}
