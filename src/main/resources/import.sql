--truncate table eventos cascade;

insert into tag (id, data_inclusao, data_alteracao, nome, valor) values (nextval('seq_evento_tags'), now(), now(), 'astronomia','Astronomia');
insert into tag (id, data_inclusao, data_alteracao, nome, valor) values (nextval('seq_evento_tags'), now(), now(), 'almoco','Almoço');
insert into tag (id, data_inclusao, data_alteracao, nome, valor) values (nextval('seq_evento_tags'), now(), now(), 'churrasco','Churrasco');
insert into tag (id, data_inclusao, data_alteracao, nome, valor) values (nextval('seq_evento_tags'), now(), now(), 'cerveja','Cerveja');

insert into categoria (id, data_inclusao, data_alteracao, nome, valor) values (nextval('seq_evento_categoria'), now(), now(), 'infantil','Infantil');
insert into categoria (id, data_inclusao, data_alteracao, nome, valor) values (nextval('seq_evento_categoria'), now(), now(), 'comer_e_beber','Comer e Beber');

insert into evento (id,link,corpo_principal, data_alteracao, data_inclusao, endereco, local, nome, origem_informacao) values (nextval('seq_evento'), 'churras_1', 'O Churras na casa do Marcão é considerado o melhor churrasco da história de Curitiba', now(), now(), 'BR 101, Km 87', 'Casa do Marcão', 'Churras 1', 'PromoCuritiba');

insert into data (id, data_inclusao, data_alteracao, data_inicio, data_fim, id_evento) values (nextval('seq_evento_data'), now(), now(), now()::date + interval '11 hours', now()::date + interval '12 hours', (select id from evento where nome = 'Churras 1'));
insert into data (id, data_inclusao, data_alteracao, data_inicio, data_fim, id_evento) values (nextval('seq_evento_data'), now(), now(), now()::date + interval '15 hours', now()::date + interval '16 hours', (select id from evento where nome = 'Churras 1'));
insert into data (id, data_inclusao, data_alteracao, data_inicio, data_fim, id_evento) values (nextval('seq_evento_data'), now(), now(), now()::date + interval '15 hours' + interval '1 day', now()::date + interval '16 hours' + interval '1 day', (select id from evento where nome = 'Churras 1'));
insert into data (id, data_inclusao, data_alteracao, data_inicio, data_fim, id_evento) values (nextval('seq_evento_data'), now(), now(), now()::date + interval '15 hours' + interval '2 days', now()::date + interval '16 hours' + interval '2 days', (select id from evento where nome = 'Churras 1'));

insert into custo (id, data_inclusao, data_alteracao, nome, valor, id_evento) values (nextval('seq_evento_custos'),now(), now(), 'Inteira', 50.00,(select id from evento where nome = 'Churras 1'));
insert into custo (id, data_inclusao, data_alteracao, nome, valor, id_evento) values (nextval('seq_evento_custos'),now(), now(), 'Crianças', 25.00,(select id from evento where nome = 'Churras 1'));
insert into custo (id, data_inclusao, data_alteracao, nome, valor, id_evento) values (nextval('seq_evento_custos'),now(), now(), 'Idosos', 50.00,(select id from evento where nome = 'Churras 1'));

insert into informacao (id, data_inclusao, data_alteracao, nome, valor, id_evento) values (nextval('seq_evento_info'),now(), now(), 'Carnes', 'Picanha, Costela, Frango',(select id from evento where nome = 'Churras 1'));
insert into informacao (id, data_inclusao, data_alteracao, nome, valor, id_evento) values (nextval('seq_evento_info'),now(), now(), 'Refrigerantes', 'Coca, Guaraná',(select id from evento where nome = 'Churras 1'));
insert into informacao (id, data_inclusao, data_alteracao, nome, valor, id_evento) values (nextval('seq_evento_info'),now(), now(), 'Cervejas', 'Trazer o que for beber',(select id from evento where nome = 'Churras 1'));

insert into imagem (id, data_inclusao, data_alteracao, nome, valor, id_evento) values (nextval('seq_evento_imagem'),now(), now(), 'churras', 'img/cabin.png',(select id from evento where nome = 'Churras 1'));

insert into evento_tag (id_evento, id_tag) values ((select id from evento where nome = 'Churras 1'), (select id from tag where valor = 'Churrasco'));
insert into evento_tag (id_evento, id_tag) values ((select id from evento where nome = 'Churras 1'), (select id from tag where valor = 'Cerveja'));

insert into evento_categoria (id_evento, id_categoria) values ((select id from evento where nome = 'Churras 1'), (select id from categoria where valor = 'Comer e Beber'));

-------------------------------------------

insert into evento (id,link,corpo_principal, data_alteracao, data_inclusao, endereco, local, nome, origem_informacao) values (nextval('seq_evento'),'trucostela', 'Campeonato de Truco + Costela... Tem coisa melhor?', now(), now(), 'Passaúna', 'Chácara Passaúna', 'Trucostela', 'PromoCuritiba');

insert into data (id, data_inclusao, data_alteracao, data_inicio, data_fim, id_evento) values (nextval('seq_evento_data'), now(), now(), now()::date + interval '18 hours', now()::date + interval '22 hours', (select id from evento where nome = 'Trucostela'));
insert into data (id, data_inclusao, data_alteracao, data_inicio, data_fim, id_evento) values (nextval('seq_evento_data'), now(), now(), now()::date + interval '18 hours' + interval '1 day', now()::date + interval '22 hours' + interval '1 day', (select id from evento where nome = 'Trucostela'));
insert into data (id, data_inclusao, data_alteracao, data_inicio, data_fim, id_evento) values (nextval('seq_evento_data'), now(), now(), now()::date + interval '18 hours' + interval '2 days', now()::date + interval '22 hours' + interval '2 days', (select id from evento where nome = 'Trucostela'));

insert into custo (id, data_inclusao, data_alteracao, nome, valor, id_evento) values (nextval('seq_evento_custos'),now(), now(), 'Inteira', 30.00,(select id from evento where nome = 'Trucostela'));
insert into custo (id, data_inclusao, data_alteracao, nome, valor, id_evento) values (nextval('seq_evento_custos'),now(), now(), 'Crianças', 15.00,(select id from evento where nome = 'Trucostela'));
insert into custo (id, data_inclusao, data_alteracao, nome, valor, id_evento) values (nextval('seq_evento_custos'),now(), now(), 'Idosos', 30.00,(select id from evento where nome = 'Trucostela'));

insert into informacao (id, data_inclusao, data_alteracao, nome, valor, id_evento) values (nextval('seq_evento_info'),now(), now(), 'Carnes', 'Costela de Chão',(select id from evento where nome = 'Trucostela'));
insert into informacao (id, data_inclusao, data_alteracao, nome, valor, id_evento) values (nextval('seq_evento_info'),now(), now(), 'Refrigerantes', 'Coca Cola',(select id from evento where nome = 'Trucostela'));
insert into informacao (id, data_inclusao, data_alteracao, nome, valor, id_evento) values (nextval('seq_evento_info'),now(), now(), 'Cervejas', 'Por conta de cada um.',(select id from evento where nome = 'Trucostela'));

insert into imagem (id, data_inclusao, data_alteracao, nome, valor, id_evento) values (nextval('seq_evento_imagem'),now(), now(), 'trucostela', 'img/cake.png',(select id from evento where nome = 'Trucostela'));

insert into evento_categoria (id_evento, id_categoria) values ((select id from evento where nome = 'Trucostela'), (select id from categoria where valor = 'Infantil'));