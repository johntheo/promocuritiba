package com.marcoscarvalho.promocuritiba.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

//import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role { //implements GrantedAuthority {

//	private static final long serialVersionUID = 1L;

	@Id
	private String nome;

	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "roles")
	private Set<Usuario> usuarios = new HashSet<Usuario>();

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Role [nome=" + nome + "]";
	}

//	@Override
//	public String getAuthority() {
//		return getNome();
//	}
}
