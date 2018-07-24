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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.marcoscarvalho.promocuritiba.service.Constantes;

@Entity
@Table(name = "evento")
public class Evento {

	public static final String SEQ = "seq_evento";
	public static final String SEQ_CATEGORIA = "seq_evento_categoria";
	public static final String SEQ_DATA = "seq_evento_data";
	public static final String SEQ_IMAGEM = "seq_evento_imagem";
	public static final String SEQ_INFO = "seq_evento_info";
	public static final String SEQ_TAGS = "seq_evento_tags";
	public static final String SEQ_VALORES = "seq_evento_custos";

	@Id
	@Column
	@SequenceGenerator(name = Evento.SEQ, sequenceName = Evento.SEQ, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = Evento.SEQ)
	private long id;

	@Column
	private String nome;

	@Column
	private String link;

	@Column
	private String corpoPrincipal;

	@Column(nullable = false, insertable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInclusao = new Date();

	@Column(nullable = false, insertable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAlteracao = new Date();

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_evento")
	private Set<Data> datas = new HashSet<Data>();

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_evento")
	private Set<Custo> custos = new HashSet<Custo>();

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_evento")
	private Set<Informacao> informacoes = new HashSet<Informacao>();

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_evento")
	private Set<Imagem> imagens = new HashSet<Imagem>();

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "evento_tag", joinColumns = { @JoinColumn(name = "id_evento") }, inverseJoinColumns = {
			@JoinColumn(name = "id_tag") })
	private Set<Tag> tags = new HashSet<Tag>();

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "evento_categoria", joinColumns = { @JoinColumn(name = "id_evento") }, inverseJoinColumns = {
			@JoinColumn(name = "id_categoria") })
	private Set<Categoria> categorias = new HashSet<Categoria>();

	@Column
	private String local;

	@Column
	private String endereco;

	@Column
	private String origemInformacao;
	
	@Transient private String variasDatasInicio;
	@Transient private String variasDatasTermino;
	@Transient private String variosCustoNome;
	@Transient private String variosCustoValor;
	@Transient private String variosInformacaoNome;
	@Transient private String variosInformacaoValor;
	@Transient private String variasImagensNome;
	@Transient private String variasImagensValor;
	@Transient private String variasTags;
	@Transient private String variasCategorias;
	
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

	public Set<Data> getDatas() {
		return datas;
	}

	public void setDatas(Set<Data> datas) {
		this.datas = datas;
	}

	public Set<Informacao> getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(Set<Informacao> informacoes) {
		this.informacoes = informacoes;
	}

	public Set<Imagem> getImagens() {
		return imagens;
	}

	public void setImagens(Set<Imagem> imagens) {
		this.imagens = imagens;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Set<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public Set<Custo> getCustos() {
		return custos;
	}

	public void setCustos(Set<Custo> custos) {
		this.custos = custos;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nome=" + nome + ", link=" + link + ", corpoPrincipal=" + corpoPrincipal
				+ ", dataInclusao=" + dataInclusao + ", dataAlteracao=" + dataAlteracao + ", datas=" + datas
				+ ", custos=" + custos + ", informacoes=" + informacoes + ", imagens=" + imagens + ", tags=" + tags
				+ ", categorias=" + categorias + ", local=" + local + ", endereco=" + endereco + ", origemInformacao="
				+ origemInformacao + "]";
	}
	
	public String getCategoriaStr() {
		return Constantes.retorarString(getCategorias(), Constantes.VIRGULA);
	}
	
	public String getTagStr() {
		return Constantes.retorarString(getTags(), Constantes.VIRGULA);
	}

	public String getVariasDatasInicio() {
		return variasDatasInicio;
	}

	public void setVariasDatasInicio(String variasDatasInicio) {
		this.variasDatasInicio = variasDatasInicio;
	}

	public String getVariasDatasTermino() {
		return variasDatasTermino;
	}

	public void setVariasDatasTermino(String variasDatasTermino) {
		this.variasDatasTermino = variasDatasTermino;
	}

	public String getVariosCustoNome() {
		return variosCustoNome;
	}

	public void setVariosCustoNome(String variosCustoNome) {
		this.variosCustoNome = variosCustoNome;
	}

	public String getVariosCustoValor() {
		return variosCustoValor;
	}

	public void setVariosCustoValor(String variosCustoValor) {
		this.variosCustoValor = variosCustoValor;
	}

	public String getVariosInformacaoNome() {
		return variosInformacaoNome;
	}

	public void setVariosInformacaoNome(String variosInformacaoNome) {
		this.variosInformacaoNome = variosInformacaoNome;
	}

	public String getVariosInformacaoValor() {
		return variosInformacaoValor;
	}

	public void setVariosInformacaoValor(String variosInformacaoValor) {
		this.variosInformacaoValor = variosInformacaoValor;
	}

	public String getVariasImagensNome() {
		return variasImagensNome;
	}

	public void setVariasImagensNome(String variasImagensNome) {
		this.variasImagensNome = variasImagensNome;
	}

	public String getVariasImagensValor() {
		return variasImagensValor;
	}

	public void setVariasImagensValor(String variasImagensValor) {
		this.variasImagensValor = variasImagensValor;
	}

	public String getVariasTags() {
		return variasTags;
	}

	public void setVariasTags(String variasTags) {
		this.variasTags = variasTags;
	}

	public String getVariasCategorias() {
		return variasCategorias;
	}

	public void setVariasCategorias(String variasCategorias) {
		this.variasCategorias = variasCategorias;
	}

}
