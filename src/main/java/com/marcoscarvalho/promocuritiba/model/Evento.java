package com.marcoscarvalho.promocuritiba.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "evento")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String nome;

	@Column
	private String corpoPrincipal;

	@Column(nullable = false, insertable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInclusao;

	@Column(nullable = false, insertable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAlteracao;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_evento")
	private Set<EventoData> datas = new HashSet<EventoData>();

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_evento")
	private Set<EventoValores> valores = new HashSet<EventoValores>();

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_evento")
	private Set<EventoInfo> informacoes = new HashSet<EventoInfo>();
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_evento")
	private Set<EventoImagem> imagens = new HashSet<EventoImagem>();

	@Column
	private String local;

	@Column
	private String endereco;

	@Column
	private String origemInformacao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getOrigemInformacao() {
		return origemInformacao;
	}

	public void setOrigemInformacao(String origemInformacao) {
		this.origemInformacao = origemInformacao;
	}

	public String getCorpoPrincipal() {
		return corpoPrincipal;
	}

	public void setCorpoPrincipal(String corpoPrincipal) {
		this.corpoPrincipal = corpoPrincipal;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nome=" + nome + ", corpoPrincipal=" + corpoPrincipal + ", dataInclusao="
				+ dataInclusao + ", dataAlteracao=" + dataAlteracao + ", datas=" + datas + ", valores=" + valores
				+ ", imagens=" + imagens
				+ ", informacoes=" + informacoes + ", local=" + local + ", endereco=" + endereco + ", origemInformacao="
				+ origemInformacao + "]";
	}

	public Set<EventoData> getDatas() {
		return datas;
	}

	public void setDatas(Set<EventoData> datas) {
		this.datas = datas;
	}

	public Set<EventoValores> getValores() {
		return valores;
	}

	public void setValores(Set<EventoValores> valores) {
		this.valores = valores;
	}

	public Set<EventoInfo> getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(Set<EventoInfo> informacoes) {
		this.informacoes = informacoes;
	}

	public Set<EventoImagem> getImagens() {
		return imagens;
	}

	public void setImagens(Set<EventoImagem> imagens) {
		this.imagens = imagens;
	}

}
