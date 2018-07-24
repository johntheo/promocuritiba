package com.marcoscarvalho.promocuritiba.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.marcoscarvalho.promocuritiba.model.Categoria;
import com.marcoscarvalho.promocuritiba.model.Custo;
import com.marcoscarvalho.promocuritiba.model.Data;
import com.marcoscarvalho.promocuritiba.model.Evento;
import com.marcoscarvalho.promocuritiba.model.Imagem;
import com.marcoscarvalho.promocuritiba.model.Informacao;
import com.marcoscarvalho.promocuritiba.model.Tag;
import com.marcoscarvalho.promocuritiba.service.Constantes;
import com.marcoscarvalho.promocuritiba.service.EventoService;

@Controller
public class CadastrarEventoController {
	
	@Autowired
	private Logger logger;
	
	@Autowired
	private EventoService eventoService;
	
	public List<Evento> eventos = new ArrayList<Evento>();

	@RequestMapping(value = "/interno/cadastrar-evento.html", method = RequestMethod.GET)
	public String cadastrarEventoGet() {
		return "interno/cadastrar-evento";
	}

	@RequestMapping(value = "/interno/cadastrar-evento.html", method = RequestMethod.POST)
	public String cadastrarEventoPost(@ModelAttribute("evento") Evento evento) {
		logger.info("Salvando o evento >> " + evento);
		
		ajustarData(evento);
		ajustarImagens(evento);
		ajustarCustos(evento);
		ajustarInformacoes(evento);
		ajustarTags(evento);
		ajustarCategorias(evento);

		eventos.add(eventoService.salvarEvento(evento));
		return "redirect:/interno/";
	}

	private void ajustarData(Evento evento) {
		String[] vdi = evento.getVariasDatasInicio().split(",");
		String[] vdt = evento.getVariasDatasTermino().split(",");
		for (int i = 0; i < vdt.length; i++) {
			evento.getDatas().add(new Data(Constantes.retornarDate(vdi[i]), Constantes.retornarDate(vdt[i])));
		}
	}
	
	private void ajustarImagens(Evento evento) {
		String[] vdi = evento.getVariasImagensNome().split(",");
		String[] vdt = evento.getVariasImagensValor().split(",");
		for (int i = 0; i < vdt.length; i++) {
			evento.getImagens().add(new Imagem(vdi[i], vdt[i]));
		}
	}
	
	private void ajustarCustos(Evento evento) {
		String[] vdi = evento.getVariosCustoNome().split(",");
		String[] vdt = evento.getVariosCustoValor().split(",");
		for (int i = 0; i < vdt.length; i++) {
			evento.getCustos().add(new Custo(vdi[i], new BigDecimal(vdt[i])));
		}
	}
	
	private void ajustarInformacoes(Evento evento) {
		String[] vdi = evento.getVariosInformacaoNome().split(",");
		String[] vdt = evento.getVariosInformacaoValor().split(",");
		for (int i = 0; i < vdt.length; i++) {
			evento.getInformacoes().add(new Informacao(vdi[i], vdt[i]));
		}
	}
	
	private void ajustarTags(Evento evento) {
		String[] tags = evento.getVariasTags().split(",");
		for (String t : tags) {
			evento.getTags().add(new Tag(Constantes.ajustarString(t)));
		}
	}
	
	private void ajustarCategorias(Evento evento) {
		String[] categorias = evento.getVariasCategorias().split(",");
		for (String c : categorias) {
			evento.getCategorias().add(new Categoria(Constantes.ajustarString(c)));
		}
	}

}
