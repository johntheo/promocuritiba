--truncate table evento cascade;

select * from evento;
select * from evento_data;
select * from evento_info;
select * from evento_valores;
SELECT * FROM EVENTO E, EVENTO_DATA D WHERE e.id = d.id_evento and d.data_inicio >= now() order by d.data_inicio;
SELECT * FROM EVENTO_DATA D WHERE d.data_inicio >= now() order by d.data_inicio;