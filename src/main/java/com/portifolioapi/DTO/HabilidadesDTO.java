package com.portifolioapi.DTO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
public class HabilidadesDTO {
	
	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private String nome;
	
	@Getter @Setter
	private Integer nivel;
}
