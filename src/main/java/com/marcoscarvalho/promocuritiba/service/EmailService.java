package com.marcoscarvalho.promocuritiba.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.marcoscarvalho.promocuritiba.model.Email;

@Service
public class EmailService {

	@Autowired
	private Logger logger;

	@Autowired
	public JavaMailSender emailSender;

	public boolean enviarEmail(Email email) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("marcos@promocuritiba.com");
			message.setTo("marcos@promocuritiba.com");
			message.setReplyTo(email.getEmail());
			message.setSubject("From Site >> " + email.getEmail());
			message.setText(email.toString());
			emailSender.send(message);
			logger.info("Email enviado >> " + email.toString());

			return true;

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return false;
	}

}
