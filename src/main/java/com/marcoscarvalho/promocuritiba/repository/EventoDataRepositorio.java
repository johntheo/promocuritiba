package com.marcoscarvalho.promocuritiba.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marcoscarvalho.promocuritiba.model.EventoData;

@Repository
public interface EventoDataRepositorio extends CrudRepository<EventoData, Long> {

	@Cacheable("proximosEventos")
	@Query(value = "SELECT * FROM EVENTO_DATA D WHERE d.data_inicio >= now() order by d.data_inicio", nativeQuery = true)
	public List<EventoData> findNextEvents();
}
