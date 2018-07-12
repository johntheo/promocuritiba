--truncate table evento cascade;

insert into evento (id,corpo_principal, data_alteracao, data_inclusao, endereco, local, nome, origem_informacao) values (nextval('seq_evento'), 'O Churras na casa do Marcão é considerado o melhor churrasco da história de Curitiba', now(), now(), 'Rua Carambolas, 196', 'Casa do Marcão', 'Churras 1', 'PromoCuritiba');

insert into evento_data (id, data_inclusao, data_alteracao, data_inicio, data_fim, id_evento) values (nextval('seq_evento_data'), now(), now(), now()::date + interval '11 hours', now()::date + interval '12 hours', (select id from evento where nome = 'Churras 1'));
insert into evento_data (id, data_inclusao, data_alteracao, data_inicio, data_fim, id_evento) values (nextval('seq_evento_data'), now(), now(), now()::date + interval '15 hours', now()::date + interval '16 hours', (select id from evento where nome = 'Churras 1'));
insert into evento_data (id, data_inclusao, data_alteracao, data_inicio, data_fim, id_evento) values (nextval('seq_evento_data'), now(), now(), now()::date + interval '15 hours' + interval '1 day', now()::date + interval '16 hours' + interval '1 day', (select id from evento where nome = 'Churras 1'));
insert into evento_data (id, data_inclusao, data_alteracao, data_inicio, data_fim, id_evento) values (nextval('seq_evento_data'), now(), now(), now()::date + interval '15 hours' + interval '2 days', now()::date + interval '16 hours' + interval '2 days', (select id from evento where nome = 'Churras 1'));

insert into evento_valores (id, data_inclusao, data_alteracao, nome, valor, id_evento) values (nextval('seq_evento_valores'),now(), now(), 'Inteira', 50.00,(select id from evento where nome = 'Churras 1'));
insert into evento_valores (id, data_inclusao, data_alteracao, nome, valor, id_evento) values (nextval('seq_evento_valores'),now(), now(), 'Crianças', 25.00,(select id from evento where nome = 'Churras 1'));
insert into evento_valores (id, data_inclusao, data_alteracao, nome, valor, id_evento) values (nextval('seq_evento_valores'),now(), now(), 'Idosos', 50.00,(select id from evento where nome = 'Churras 1'));

insert into evento_info (id, data_inclusao, data_alteracao, nome, valor, id_evento) values (nextval('seq_evento_info'),now(), now(), 'Carnes', 'Picanha, Costela, Frango',(select id from evento where nome = 'Churras 1'));
insert into evento_info (id, data_inclusao, data_alteracao, nome, valor, id_evento) values (nextval('seq_evento_info'),now(), now(), 'Refrigerantes', 'Coca, Guaraná',(select id from evento where nome = 'Churras 1'));
insert into evento_info (id, data_inclusao, data_alteracao, nome, valor, id_evento) values (nextval('seq_evento_info'),now(), now(), 'Cervejas', 'Trazer o que for beber',(select id from evento where nome = 'Churras 1'));

-------------------------------------------

insert into evento (id,corpo_principal, data_alteracao, data_inclusao, endereco, local, nome, origem_informacao) values (nextval('seq_evento'), 'Campeonato de Truco + Costela... Tem coisa melhor?', now(), now(), 'Passaúna', 'Chácara Passaúna', 'Trucostela', 'PromoCuritiba');

insert into evento_data (id, data_inclusao, data_alteracao, data_inicio, data_fim, id_evento) values (nextval('seq_evento_data'), now(), now(), now()::date + interval '18 hours', now()::date + interval '22 hours', (select id from evento where nome = 'Trucostela'));
insert into evento_data (id, data_inclusao, data_alteracao, data_inicio, data_fim, id_evento) values (nextval('seq_evento_data'), now(), now(), now()::date + interval '18 hours' + interval '1 day', now()::date + interval '22 hours' + interval '1 day', (select id from evento where nome = 'Trucostela'));
insert into evento_data (id, data_inclusao, data_alteracao, data_inicio, data_fim, id_evento) values (nextval('seq_evento_data'), now(), now(), now()::date + interval '18 hours' + interval '2 days', now()::date + interval '22 hours' + interval '2 days', (select id from evento where nome = 'Trucostela'));

insert into evento_valores (id, data_inclusao, data_alteracao, nome, valor, id_evento) values (nextval('seq_evento_valores'),now(), now(), 'Inteira', 30.00,(select id from evento where nome = 'Trucostela'));
insert into evento_valores (id, data_inclusao, data_alteracao, nome, valor, id_evento) values (nextval('seq_evento_valores'),now(), now(), 'Crianças', 15.00,(select id from evento where nome = 'Trucostela'));
insert into evento_valores (id, data_inclusao, data_alteracao, nome, valor, id_evento) values (nextval('seq_evento_valores'),now(), now(), 'Idosos', 30.00,(select id from evento where nome = 'Trucostela'));

insert into evento_info (id, data_inclusao, data_alteracao, nome, valor, id_evento) values (nextval('seq_evento_info'),now(), now(), 'Carnes', 'Costela de Chão',(select id from evento where nome = 'Trucostela'));
insert into evento_info (id, data_inclusao, data_alteracao, nome, valor, id_evento) values (nextval('seq_evento_info'),now(), now(), 'Refrigerantes', 'Coca Cola',(select id from evento where nome = 'Trucostela'));
insert into evento_info (id, data_inclusao, data_alteracao, nome, valor, id_evento) values (nextval('seq_evento_info'),now(), now(), 'Cervejas', 'Por conta de cada um.',(select id from evento where nome = 'Trucostela'));