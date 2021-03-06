package com.marcoscarvalho.promocuritiba.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.marcoscarvalho.promocuritiba.service.EventoService;

@Controller
public class IndexController {

	@Autowired
	private Logger logger;

	@Autowired
	private EventoService eventoService;

	@GetMapping("/")
	public String index(@ModelAttribute("model") ModelMap model) {
		logger.info("index >> /");
		model.addAttribute("ultimaAtualizacaoEventos", eventoService.consultarUltimaAtualizacaoEventos());
		model.addAttribute("eventos", eventoService.consultarProximosEventos());
		model.addAttribute("objetoEventos", eventoService.consultarProximosObjetosEventos());
		return "index";
	}


	@GetMapping("/index.html")
	public String indexHtml(@ModelAttribute("model") ModelMap model) {
		logger.info("index >> /index.html");
		model.addAttribute("ultimaAtualizacaoEventos", eventoService.consultarUltimaAtualizacaoEventos());
		model.addAttribute("eventos", eventoService.consultarProximosEventos());
		model.addAttribute("objetoEventos", eventoService.consultarProximosObjetosEventos());
		return "index";
	}
	
	@GetMapping("/original.html")
	public String original() {
		logger.info("Acessando a página original.html");
		return "original";
	}

}
