package com.portifolioapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.portifolioapi.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private HabilidadeRepository habilidadeRepository;

	Usuario user = new Usuario();

	@Override
	public List<Usuario> listarTodos() {
		return usuarioRepository.findAll();
	}

	@Override
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

	@Override
	public void deletar(Long id) {
		usuarioRepository.deleteById(id);
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

	@Override
	public void atualizar(UsuarioDTO usuarioDTO) {

		usuarioRepository.findById(usuarioDTO.getId()).map(user -> {

			user.setNome(usuarioDTO.getNome());
			user.setCargo(usuarioDTO.getCargo());
			user.setResumo(usuarioDTO.getResumo());
			user.setFoto(usuarioDTO.getFoto());
			user.setCurriculo(usuarioDTO.getCurriculo());
			
			usuarioRepository.save(user);

			for (EmpresasDTO businnes : usuarioDTO.getEmpresas()) {

				empresaRepository.findById(businnes.getId()).map(emp -> {

					emp.setNome(businnes.getNome());
					emp.setCargo(businnes.getCargo());
					emp.setInicio(businnes.getInicio());
					emp.setFim(businnes.getFim());
					emp.setAtividades(businnes.getAtividades());
					emp.setUsuario(user);

					empresaRepository.save(emp);
					return ResponseEntity.ok();
				});
			}

			for (HabilidadesDTO habilits : usuarioDTO.getHabilidades()) {

				habilidadeRepository.findById(habilits.getId()).map(skill -> {

					skill.setNome(habilits.getNome());
					skill.setNivel(habilits.getNivel());
					skill.setUsuario(user);

					habilidadeRepository.save(skill);
					return ResponseEntity.ok();
				});
			}
			
			return ResponseEntity.ok();
		});
	}
}
