package com.marcoscarvalho.promocuritiba.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marcoscarvalho.promocuritiba.model.Evento;

@Repository
public interface EventoRepositorio extends CrudRepository<Evento, Long> {

	@Query(value = "SELECT * FROM EVENTO E, EVENTO_DATA D WHERE e.id = d.id_evento and d.data_inicio >= now() order by d.data_inicio ", nativeQuery = true)
	public List<Evento> findNextEvents();

	@Query(value = "SELECT * FROM EVENTO E, EVENTO_DATA D WHERE e.id = d.id_evento and d.data_inicio >= ?1 order by d.data_inicio ", nativeQuery = true)
	public List<Evento> findNextEvents(Calendar data);

	@Query(value = "SELECT * FROM EVENTO E, EVENTO_DATA D WHERE e.id = d.id_evento and d.data_inicio between ?1 and ?2 order by d.data_inicio ", nativeQuery = true)
	public List<Evento> findNextEvents(Calendar dataInicio, Calendar dataFim);
}
