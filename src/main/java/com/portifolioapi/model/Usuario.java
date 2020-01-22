package com.portifolioapi.model;

import java.io.File;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter @Setter
	private String nome;
	
	@Getter @Setter
	private String cargo;
	
	@Getter @Setter
	private String resumo;
	
	@Getter @Setter
	@JsonManagedReference
	@OneToMany(mappedBy="usuario")
    private List<Empresas> empresas;
	
	@Getter @Setter
	@JsonManagedReference
	@OneToMany(mappedBy="usuario")
    private List<Habilidades> habilidades;
	
	@Getter @Setter
    private File foto;
	
	@Getter @Setter
    private File curriculo;

}
