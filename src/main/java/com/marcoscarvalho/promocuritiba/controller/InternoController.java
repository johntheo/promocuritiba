package com.marcoscarvalho.promocuritiba.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InternoController {
	
	@Autowired
	private Logger logger;
	
	@GetMapping("/interno/blank.html")
	public String blank() {
		return "/interno/blank";
	}

	@GetMapping("/interno/forgot-password.html")
	public String forgotPassword() {
		return "/interno/forgot-password";
	}
	
	@GetMapping("/interno/")
	public String indexBarra() {
		return "/interno/index";
	}

	@GetMapping("/interno/index.html")
	public String index() {
		return "/interno/index";
	}

	@GetMapping("/interno/register.html")
	public String register() {
		return "/interno/register";
	}
	
	@GetMapping("/interno/original.html")
	public String original() {
		logger.info("Acessando a página interno original.html");
		return "/interno/original";
	}
	
}
