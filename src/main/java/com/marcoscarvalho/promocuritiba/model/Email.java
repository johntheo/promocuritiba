package com.marcoscarvalho.promocuritiba.model;

public class Email {

	private String nome;
	private String email;
	private String telefone;
	private String mensagem;

	public Email() {

	}

	public Email(String nome, String email, String telefone, String mensagem) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.mensagem = mensagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public String toString() {
		return "Email [nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", mensagem=" + mensagem + "]";
	}

}
