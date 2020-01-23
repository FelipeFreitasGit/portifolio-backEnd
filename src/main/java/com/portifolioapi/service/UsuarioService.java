package com.portifolioapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portifolioapi.DTO.EmpresasDTO;
import com.portifolioapi.DTO.HabilidadesDTO;
import com.portifolioapi.DTO.UsuarioDTO;
import com.portifolioapi.model.Empresas;
import com.portifolioapi.model.Habilidades;
import com.portifolioapi.model.Usuario;
import com.portifolioapi.repository.EmpresaRepository;
import com.portifolioapi.repository.HabilidadeRepository;
import com.portifolioapi.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private HabilidadeRepository habilidadeRepository;

	Usuario user = new Usuario();

	public UsuarioDTO salvarUsuario(UsuarioDTO usuario) {

		user.setNome(usuario.getNome());
		user.setCargo(usuario.getCargo());
		user.setResumo(usuario.getResumo());
		user.setFoto(usuario.getFoto());
		user.setCurriculo(usuario.getCurriculo());

		usuarioRepository.save(user);

		for (EmpresasDTO businnes : usuario.getEmpresas()) {

			this.salvarEmpresa(businnes);
		}

		for (HabilidadesDTO habilits : usuario.getHabilidades()) {

			this.salvarHabilidades(habilits);
		}

		return usuario;
	}

	public Empresas salvarEmpresa(EmpresasDTO businnes) {

		Empresas emp = new Empresas();
		emp.setNome(businnes.getNome());
		emp.setCargo(businnes.getCargo());
		emp.setInicio(businnes.getInicio());
		emp.setFim(businnes.getFim());
		emp.setAtividades(businnes.getAtividades());
		emp.setUsuario(user);

		return empresaRepository.save(emp);
	}

	public Habilidades salvarHabilidades(HabilidadesDTO habilits) {

		Habilidades skill = new Habilidades();
		skill.setNome(habilits.getNome());
		skill.setNivel(habilits.getNivel());
		skill.setUsuario(user);

		return habilidadeRepository.save(skill);
	}

	public List<Usuario> listarTodos() {
		return usuarioRepository.findAll();
	}

	public void deletar(Long id) {

		usuarioRepository.deleteById(id);
	}

}
