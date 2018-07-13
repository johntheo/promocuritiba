package com.marcoscarvalho.promocuritiba.service;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcoscarvalho.promocuritiba.model.Evento;
import com.marcoscarvalho.promocuritiba.model.Data;
import com.marcoscarvalho.promocuritiba.repository.EventoDataRepositorio;
import com.marcoscarvalho.promocuritiba.repository.EventoRepositorio;

@Service
public class EventoService {

	@Autowired
	private Logger logger;

	@Autowired
	private EventoRepositorio eventoRepositorio;

	@Autowired
	private EventoDataRepositorio eventoDataRepositorio;

	public List<Data> consultarProximosEventos() {
		List<Data> list = eventoDataRepositorio.findNextEvents();
		List<Data> listRetorno = new LinkedList<Data>();

		for (Data eventoData : list) {
			if (new Date().before(eventoData.getDataInicio())) {
				listRetorno.add(eventoData);
			}
		}

		logger.info(
				"consultarProximosEventos >> proximos >> " + list.size() + ", listRetorno >> " + listRetorno.size());

		return listRetorno;
	}
	
	public List<Evento> consultarProximosObjetosEventos() {
		List<Evento> list = eventoRepositorio.findNextEvents();
		logger.info(
				"consultarProximosObjetosEventos >> proximos >> " + list.size());
		
		return list;
	}

	public Date consultarUltimaAtualizacaoEventos() {
		return eventoRepositorio.findLastUpdate();
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
