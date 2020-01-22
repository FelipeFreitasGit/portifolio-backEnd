package com.portifolioapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Entity
@Table(name = "empresas")
public class Empresas {
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter @Setter
	private String nome; 
	
	@Getter @Setter
	private String cargo;
	
	@Getter @Setter
	private String inicio;
	
	@Getter @Setter
	private String fim;
	
	@Getter @Setter
	private String atividades;
	
	@Getter @Setter
	@JsonBackReference
	@ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id")
	private Usuario usuario;
}
