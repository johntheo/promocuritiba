package com.marcoscarvalho.promocuritiba.service;

import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcoscarvalho.promocuritiba.model.Evento;
import com.marcoscarvalho.promocuritiba.repository.EventoRepositorio;

@Service
public class EventoService {

	@Autowired
	private Logger logger;

	@Autowired
	private EventoRepositorio eventoRepositorio;

	public List<Evento> consultarProximosEventos() {
		List<Evento> list = eventoRepositorio.findNextEvents();
		logger.info("consultarProximosEventos >> proximos >> " + list.size());
		return list;
	}

	public List<Evento> consultarProximosEventos(Calendar data) {
		List<Evento> list = eventoRepositorio.findNextEvents(data);
		logger.info("consultarProximosEventos >> data >> " + data + " >> " + list.size());
		return list;
	}

	public List<Evento> consultarProximosEventos(Calendar dataInicio, Calendar dataFim) {
		List<Evento> list = eventoRepositorio.findNextEvents(dataInicio, dataFim);
		logger.info(
				"consultarProximosEventos >> entre datas >> " + dataInicio + " - " + dataFim + " >> " + list.size());
		return list;
	}
}
