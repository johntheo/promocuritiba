package com.marcoscarvalho.promocuritiba.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.marcoscarvalho.promocuritiba.model.Usuario;
import com.marcoscarvalho.promocuritiba.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private Logger logger;

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/interno/login", method = RequestMethod.GET)
	public String login2() {
		logger.info("login 2222222222");
		return "interno/login";
	}

	@RequestMapping(value = "/interno/login.html", method = RequestMethod.GET)
	public String login() {
		logger.info("Tentativa de login");
		return "interno/login";
	}

	@RequestMapping(value = "/interno/login.html", method = RequestMethod.POST)
	public String post(@ModelAttribute("usuario") Usuario usuario) {
		logger.info("Tentativa de login controller >> " + usuario);
		loginService.loadUserByUsername(usuario.getEmail());
		return "redirect:/interno/";
	}
}
