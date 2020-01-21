package com.portifolioapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portifolioapi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
