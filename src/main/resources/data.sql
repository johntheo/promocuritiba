--truncate table evento cascade;

select * from evento;
select * from data;
select * from informacao;
select * from custo;
select * from imagem;
SELECT * FROM EVENTO E, data D WHERE e.id = d.id_evento and d.data_inicio >= now() order by d.data_inicio;
SELECT * FROM DATA D WHERE d.data_inicio >= now() order by d.data_inicio;

SELECT * FROM EVENTO E WHERE exists (select 1 from data where data_inicio >= now() );
select * from evento where nome = 'Trucostela';
select * from categoria;
select * from tag;
select id from categoria where valor = 'Infantil';

select * from evento e, tag t, evento_tag et where e.id = et.id_evento and et.id_tag = t.id;