package com.portifolioapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portifolioapi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

//	@Query(
//		value = "SELECT * FROM portifolio.usuario " 
//				+ "INNER JOIN portifolio.empresas ON portifolio.usuario.id = portifolio.empresas.usuario_id " 
//				+ "INNER JOIN portifolio.habilidades ON portifolio.usuario.id = portifolio.habilidades.usuario_id",
//		nativeQuery = true)
//	List<Usuario> findAllActiveUsersNative();
}
