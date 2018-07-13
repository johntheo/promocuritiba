package com.marcoscarvalho.promocuritiba.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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

import com.marcoscarvalho.promocuritiba.service.Constantes;

@Entity
@Table(name = "eventos")
public class Evento {

	public static final String SEQ = "seq_evento";
	public static final String SEQ_CATEGORIA = "seq_evento_categoria";
	public static final String SEQ_DATA = "seq_evento_data";
	public static final String SEQ_IMAGEM = "seq_evento_imagem";
	public static final String SEQ_INFO = "seq_evento_info";
	public static final String SEQ_TAGS = "seq_evento_tags";
	public static final String SEQ_VALORES = "seq_evento_valores";

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
	private Date dataInclusao;

	@Column(nullable = false, insertable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAlteracao;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_evento")
	private Set<Data> datas = new HashSet<Data>();

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_evento")
	private Set<Valor> valores = new HashSet<Valor>();

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

	public Set<Valor> getValores() {
		return valores;
	}

	public void setValores(Set<Valor> valores) {
		this.valores = valores;
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

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nome=" + nome + ", link=" + link + ", corpoPrincipal=" + corpoPrincipal
				+ ", dataInclusao=" + dataInclusao + ", dataAlteracao=" + dataAlteracao + ", datas=" + datas
				+ ", valores=" + valores + ", informacoes=" + informacoes + ", imagens=" + imagens + ", tags=" + tags
				+ ", categorias=" + categorias + ", local=" + local + ", endereco=" + endereco + ", origemInformacao="
				+ origemInformacao + "]";
	}

	public String getTagStr() {
		return retorarString(tags, Constantes.VIRGULA);
	}

	public String getCategoriaStr() {
		return retorarString(categorias, Constantes.VIRGULA);
	}

	public String getValorStr() {
		return retorarString(valores, Constantes.NOVA_LINHA);
	}

	public String getDataStr() {
		return retorarString(datas, Constantes.NOVA_LINHA);
	}

	public String getInformacaoStr() {
		return retorarString(informacoes, Constantes.NOVA_LINHA);
	}

	private <T> String retorarString(Set<T> set, String formato) {
		String str = "";
		List<T> list = new ArrayList<T>();
		list.addAll(set);
		for (int i = 0; i < list.size(); i++) {
			str += list.get(i).toString();
			if (list.size() != (i + 1)) {
				str += formato;
			}
		}
		return str;
	}

}
