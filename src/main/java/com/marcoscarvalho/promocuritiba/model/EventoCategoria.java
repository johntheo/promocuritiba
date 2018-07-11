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
@Table(name = "evento_categoria")
public class EventoCategoria {

	@Id
	@Column
	@SequenceGenerator(name = Evento.SEQ_CATEGORIA, sequenceName = Evento.SEQ_CATEGORIA, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = Evento.SEQ_CATEGORIA)
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
	private Date dataInclusao;

	@Column(nullable = false, insertable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAlteracao;

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

	@Override
	public String toString() {
		return "EventoInfo [id=" + id + ", nome=" + nome + ", valor=" + valor + "]";
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}
