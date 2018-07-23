package com.marcoscarvalho.promocuritiba.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marcoscarvalho.promocuritiba.model.Usuario;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, String> {

	public List<Usuario> findByEmail(String email);

}
