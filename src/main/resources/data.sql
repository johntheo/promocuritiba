--truncate table evento cascade;

select * from eventos;
select * from datas;
select * from informacoes;
select * from valores;
select * from imagens;
SELECT * FROM EVENTOs E, datas D WHERE e.id = d.id_evento and d.data_inicio >= now() order by d.data_inicio;
SELECT * FROM DATAs D WHERE d.data_inicio >= now() order by d.data_inicio;

SELECT * FROM EVENTOs E WHERE exists (select 1 from datas where data_inicio >= now() );
select * from eventos where nome = 'Trucostela';
select * from categorias;
select * from tags;
select id from categorias where valor = 'Infantil';

select * from eventos e, tags t, evento_tag et where e.id = et.id_evento and et.id_tag = t.id;