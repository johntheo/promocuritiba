package com.marcoscarvalho.promocuritiba.model;

import java.math.BigDecimal;
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
@Table(name = "valores")
public class Valor {

	@Id
	@Column
	@SequenceGenerator(name = Evento.SEQ_VALORES, sequenceName = Evento.SEQ_VALORES, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = Evento.SEQ_VALORES)
	private long id;

	@ManyToOne
	@JoinColumn(name = "id_evento")
	private Evento evento;

	@Column
	private BigDecimal valor;

	@Column
	private String nome;

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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
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

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	@Override
	public String toString() {
		return nome + ": " + valor;
	}

}
