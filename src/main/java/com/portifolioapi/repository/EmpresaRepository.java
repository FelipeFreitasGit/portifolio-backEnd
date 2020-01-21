package com.portifolioapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portifolioapi.model.Empresas;

public interface EmpresaRepository extends JpaRepository<Empresas, Long>{

}
