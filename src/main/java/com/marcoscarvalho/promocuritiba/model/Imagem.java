package com.marcoscarvalho.promocuritiba.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "imagem")
public class Imagem {

	@Id
	@Column
	@SequenceGenerator(name = Evento.SEQ_IMAGEM, sequenceName = Evento.SEQ_IMAGEM, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = Evento.SEQ_IMAGEM)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "id_evento")
	private Evento evento;

	@Column
	private String nome;

	@Column
	private String valor;

	@Column(nullable = false, insertable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInclusao = new Date();

	@Column(nullable = false, insertable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAlteracao = new Date();
	
	public Imagem() {
	}
	
	public Imagem(String nome, String valor) {
		this.nome = nome;
		this.valor = valor;
	}

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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
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

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	@Override
	public String toString() {
		return "Imagem [id=" + id + ", evento=" + evento + ", nome=" + nome + ", valor=" + valor + ", dataInclusao="
				+ dataInclusao + ", dataAlteracao=" + dataAlteracao + "]";
	}

}
