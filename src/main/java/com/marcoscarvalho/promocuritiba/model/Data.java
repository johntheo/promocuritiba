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

import com.marcoscarvalho.promocuritiba.service.Constantes;

@Entity
@Table(name = "data")
public class Data {

	@Id
	@Column
	@SequenceGenerator(name = Evento.SEQ_DATA, sequenceName = Evento.SEQ_DATA, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = Evento.SEQ_DATA)
	private long id;

	@ManyToOne
	@JoinColumn(name = "id_evento")
	private Evento evento;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicio;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFim;

	@Column(nullable = false, insertable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInclusao = new Date();

	@Column(nullable = false, insertable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAlteracao = new Date();

	public Data() {
	}
	
	public Data(Date dataInicio, Date dataFim) {
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
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
		return Constantes.formartarData(dataInicio) + " - " + Constantes.formartarData(dataFim);
	}
}
