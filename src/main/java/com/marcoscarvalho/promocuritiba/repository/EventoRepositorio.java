package com.marcoscarvalho.promocuritiba.repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marcoscarvalho.promocuritiba.model.Evento;

@Repository
public interface EventoRepositorio extends CrudRepository<Evento, Long> {

	@Cacheable("proximosObjetoEventos")
	@Query(value = "SELECT * FROM EVENTOS E WHERE exists (select 1 from datas where data_inicio >= now())", nativeQuery = true)
	public List<Evento> findNextEvents();

	@Query(value = "SELECT * FROM EVENTOS E WHERE exists (select 1 from datas where data_inicio >= ?1 )", nativeQuery = true)
	public List<Evento> findNextEvents(Calendar data);

	@Query(value = "SELECT * FROM EVENTOS E WHERE exists (select 1 from datas where data_inicio between ?1 and ?2 )", nativeQuery = true)
	public List<Evento> findNextEvents(Calendar dataInicio, Calendar dataFim);
	
	@Cacheable("ultimaAtualizacao")
	@Query(value = "select max(data_alteracao) from eventos", nativeQuery = true)
	public Date findLastUpdate();
}
