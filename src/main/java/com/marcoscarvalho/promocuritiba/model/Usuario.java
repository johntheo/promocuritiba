package com.marcoscarvalho.promocuritiba.model;

//import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario {// implements UserDetails {

	//private static final long serialVersionUID = 1L;

	@Id
	private String email;
	private String nome;
	private String senha;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "Usuario_Role", joinColumns = { @JoinColumn(name = "Usuario_email") }, inverseJoinColumns = {
			@JoinColumn(name = "roles_nome") })
	private Set<Role> roles = new HashSet<Role>();
	
	public Usuario() {

	}

	public Usuario(String email, String nome, String senha, Set<Role> roles) {
		super();
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nome=" + nome + "]";
	}

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return this.roles;
//	}
//
//	@Override
//	public String getPassword() {
//		return getSenha();
//	}
//
//	@Override
//	public String getUsername() {
//		return getEmail();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}

}
