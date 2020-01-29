package com.portifolioapi.service.impl;

import static java.util.Collections.emptyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.portifolioapi.model.UsuarioLogin;
import com.portifolioapi.repository.LoginRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private LoginRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UsuarioLogin user = repo.findByUsuarioLogin(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}

		return new User(user.getUsuarioLogin(), user.getSenha(), emptyList());
	}

}
