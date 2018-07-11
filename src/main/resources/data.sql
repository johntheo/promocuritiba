truncate table evento cascade;

insert into evento 
(id,corpo_principal, data_alteracao, data_inclusao, endereco, local, nome, origem_informacao)
values 
(1, 'O Churras na casa do Marcão é considerado o melhor churrasco da história de Curitiba', now(), now(), 'Rua Carambolas, 196', 'Casa do Marcão', 'Churras 1', 'PromoCuritiba');

insert into evento_data 
(id, data_inclusao, data_alteracao, data_inicio, data_fim, id_evento)
values 
(1, now(), now(), now()::date + interval '15 hours', now()::date + interval '16 hours', 1);
insert into evento_data 
(id, data_inclusao, data_alteracao, data_inicio, data_fim, id_evento)
values 
(2, now(), now(), now()::date + interval '15 hours' + interval '1 day', now()::date + interval '16 hours' + interval '1 day', 1);
insert into evento_data 
(id, data_inclusao, data_alteracao, data_inicio, data_fim, id_evento)
values 
(3, now(), now(), now()::date + interval '15 hours' + interval '2 days', now()::date + interval '16 hours' + interval '2 days', 1);

insert into evento_valores 
(id, data_inclusao, data_alteracao, nome, valor, id_evento)
values
(1,now(), now(), 'Inteira', 50.00,1);
insert into evento_valores 
(id, data_inclusao, data_alteracao, nome, valor, id_evento)
values
(2,now(), now(), 'Crianças', 25.00,1);
insert into evento_valores 
(id, data_inclusao, data_alteracao, nome, valor, id_evento)
values
(3,now(), now(), 'Idosos', 50.00,1);

insert into evento_info
(id, data_inclusao, data_alteracao, nome, valor, id_evento)
values
(1,now(), now(), 'Carnes', 'Picanha, Costela, Frango',1);

insert into evento_info
(id, data_inclusao, data_alteracao, nome, valor, id_evento)
values
(2,now(), now(), 'Refrigerantes', 'Coca, Guaraná',1);

insert into evento_info
(id, data_inclusao, data_alteracao, nome, valor, id_evento)
values
(3,now(), now(), 'Cervejas', 'Trazer o que for beber',1);

--select * from evento;
--select * from evento_data;
--select * from evento_info;
--select * from evento_valores;
--SELECT * FROM EVENTO E, EVENTO_DATA D WHERE e.id = d.id_evento and d.data_inicio >= now() order by d.data_inicio;