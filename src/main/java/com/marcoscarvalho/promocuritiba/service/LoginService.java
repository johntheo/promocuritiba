package com.marcoscarvalho.promocuritiba.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcoscarvalho.promocuritiba.model.Usuario;
import com.marcoscarvalho.promocuritiba.repository.UsuarioRepositorio;

@Service
public class LoginService {//implements UserDetailsService {

	@Autowired
	private Logger logger;

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	//@Override
	//public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	public Usuario loadUserByUsername(String email) {
		logger.info("Tentativa de login para o usuário >> " + email);
		List<Usuario> usuarios = usuarioRepositorio.findByEmail(email);

		if (usuarios.isEmpty()) {
//			throw new UsernameNotFoundException("O usuário " + email + " não foi encontrado");
			throw new RuntimeException("O usuário " + email + " não foi encontrado");
		}

		return usuarios.get(0);
	}
}
