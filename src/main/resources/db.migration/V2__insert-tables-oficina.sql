
INSERT INTO cliente (nome,cpf,telefone) VALUES ('Usuario3', '111.111.111-11', '(55) 1 1111-1111');

INSERT INTO cliente (nome,cpf,telefone) VALUES ('Usuario1', '111.111.111-11','(55) 1 1111-1111');


INSERT INTO mecanico (nome,cpf, salario) VALUES ('Usuario1', '111.111.111-11', 2500.00);
INSERT INTO mecanico (nome,cpf, salario) VALUES ('Usuario2', '111.111.111-11', 2500.00);


INSERT INTO usuario (login, senha, permissao, fk_id_cliente) VALUES ('Usuario1', '12345', '1',2);

INSERT INTO usuario (login, senha, permissao, fk_id_cliente) VALUES ('Usuario2', '12345', '1',1);
INSERT INTO usuario (login, senha, permissao, fk_id_mecanico) VALUES ('Usuario3', '12345', '1', 2);
INSERT INTO usuario (login, senha, permissao, fk_id_mecanico) VALUES ('Usuario4', '12345', '0', 1);

INSERT INTO ordem_servico(marca, modelo, tipo, problema, status, data_entrada, id_cliente, id_mecanico, ativo) VALUES ('Marca1', 'Modelo1', 'Tipo1', 'Problema1', 'Aberta', '2023-9-1', 1, NULL, true);
INSERT INTO ordem_servico(marca, modelo, tipo, problema, status, data_entrada, id_cliente, id_mecanico, ativo) VALUES ('Marca2', 'Modelo2', 'Tipo2', 'Problema2', 'Em andamento','2023-9-2', 2, 2, true);
INSERT INTO ordem_servico(marca, modelo, tipo, problema, status, data_entrada, data_saida, total, id_cliente, id_mecanico, ativo) VALUES ('Marca3', 'Modelo3', 'Tipo3', 'Problema3', 'Fechada', '6-9-2023', '10-9-2023',100, 1, 1, false);
INSERT INTO ordem_servico(marca, modelo, tipo, problema, status, data_entrada, data_saida,total, id_cliente, id_mecanico, ativo) VALUES ('Marca3', 'Modelo3', 'Tipo3', 'Problema3', 'Fechada', '9-9-2023','12-9-2023',12.4, 2, 2, false);


-- INSERT PRODUTO CUSTO --
INSERT INTO produto_custo(nome) VALUES ('gasolina');
INSERT INTO produto_custo(nome) VALUES ('óleo');
INSERT INTO produto_custo(nome) VALUES ('horas de trabalho');


-- INSERT CUSTOS --
INSERT INTO custos(id_produtocusto, valor, id_ordemservico) VALUES (1, 20.0, 1);
INSERT INTO custos(id_produtocusto, valor, id_ordemservico) VALUES (1, 5.0, 2);
INSERT INTO custos(id_produtocusto, valor, id_ordemservico) VALUES (3, 140.00, 3);
INSERT INTO custos(id_produtocusto, valor, id_ordemservico) VALUES (1, 3.0, 4);


