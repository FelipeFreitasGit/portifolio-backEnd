package com.portifolioapi.DTO;

import java.io.File;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
public class UsuarioDTO {
	
	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private String nome;
	
	@Getter @Setter
	private String cargo;
	
	@Getter @Setter
	private String resumo;
	
	@Getter @Setter
    private List<EmpresasDTO> empresas;
	
	@Getter @Setter
    private List<HabilidadesDTO> habilidades;
	
	@Getter @Setter
    private File foto;
	
	@Getter @Setter
    private File curriculo;

}
