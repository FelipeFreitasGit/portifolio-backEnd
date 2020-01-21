package com.portifolioapi.DTO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
public class EmpresasDTO {
	
	@Getter @Setter
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
}
