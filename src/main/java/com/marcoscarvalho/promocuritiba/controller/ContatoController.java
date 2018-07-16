package com.marcoscarvalho.promocuritiba.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.marcoscarvalho.promocuritiba.model.Email;
import com.marcoscarvalho.promocuritiba.service.EmailService;

@Controller
public class ContatoController {

	@Autowired
	private Logger logger;

	@Autowired
	private EmailService emailService;

	@RequestMapping(value = "/enviarEmail.html", method = RequestMethod.POST)
	public String enviarEmail(@ModelAttribute("email") Email email, HttpServletRequest request) {
		String action = request.getRequestURL().substring(request.getRequestURL().lastIndexOf("/") + 1);
		logger.info("action >> " + action);
		logger.info("Enviar esse email >> " + email.toString());
		emailService.enviarEmail(email);
		return "redirect:/";
	}
}
