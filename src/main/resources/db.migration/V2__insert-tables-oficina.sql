-- INSERT USUÁRIO --
INSERT INTO usuario (nome, cpf, login, senha, permissao,) VALUES ('Usuario1', '111.111.111-11', 'Usuario1', '12345', '1');
INSERT INTO usuario (nome, cpf, login, senha, permissao) VALUES ('Usuario2', '222.222.222-22', 'Usuario2', '12345', '1');
INSERT INTO usuario (nome, cpf, login, senha, permissao) VALUES ('Usuario3', '333.333.333-33', 'Usuario3', '12345', '1');
INSERT INTO usuario (nome, cpf, login, senha, permissao) VALUES ('Usuario4', '444.444.444-44', 'Usuario4', '12345', '1');
INSERT INTO usuario (nome, cpf, login, senha, permissao) VALUES ('Usuario5', '555.555.555-55', 'Usuario5', '12345', '1');
INSERT INTO usuario (nome, cpf, login, senha, permissao) VALUES ('Usuario6', '666.666.666-66', 'Usuario6', '12345', '1');
INSERT INTO usuario (nome, cpf, login, senha, permissao) VALUES ('Usuario7', '777.777.777-77', 'Usuario7', '12345', '1');
INSERT INTO usuario (nome, cpf, login, senha, permissao) VALUES ('Usuario8', '888.888.888-88', 'Usuario8', '12345', '1');
INSERT INTO usuario (nome, cpf, login, senha, permissao) VALUES ('Usuario9', '999.999.999-99', 'Usuario9', '12345', '1');
INSERT INTO usuario (nome, cpf, login, senha, permissao) VALUES ('Usuario10', '000.000.000-00', 'Usuario10', '12345', '1');
INSERT INTO usuario (nome, cpf, login, senha, permissao) VALUES ('Usuario11', '100.100.100-10', 'Usuario11', '12345', '0');
INSERT INTO usuario (nome, cpf, login, senha, permissao) VALUES ('Usuario12', '200.200.200-20', 'Usuario12', '12345', '0');

-- INSERT CLIENTE --
INSERT INTO cliente (id,nome,cpf, login, senha, permissao, telefone) VALUES (1,'Usuario1', '111.111.111-11', 'Usuario1', '12345', '1','(55) 1 1111-1111');
INSERT INTO cliente (id,nome, cpf, login, senha, permissao,telefone) VALUES (2, 'Usuario2', '222.222.222-22', 'Usuario2', '12345', '1','(55) 2 2222-2222');
INSERT INTO cliente (id,nome, cpf, login, senha, permissao,telefone) VALUES (3, 'Usuario10', '000.000.000-00', 'Usuario10', '12345', '1','(55) 3 3333-3333');

-- INSERT MECÂNICO --
INSERT INTO mecanico (id,nome,cpf, login, senha, permissao, salario) VALUES (1,'Usuario11', '100.100.100-10', 'Usuario11', '12345', '0', 2500.00);
INSERT INTO mecanico (id,nome,cpf, login, senha, permissao, salario) VALUES (2,'Usuario12', '200.200.200-20', 'Usuario12', '12345', '0', 2500.00);

-- INSERT ORDEM DE SERVIÇO --
INSERT INTO ordem_servico(marca, modelo, tipo, problema, status, data_entrada, id_cliente, id_mecanico, ativo) VALUES ('Marca1', 'Modelo1', 'Tipo1', 'Problema1', 'Aberta', '2023-9-1', 1, NULL, true);
INSERT INTO ordem_servico(marca, modelo, tipo, problema, status, data_entrada, id_cliente, id_mecanico, ativo) VALUES ('Marca2', 'Modelo2', 'Tipo2', 'Problema2', 'Em andamento','2023-9-2', 2, 2, true);
INSERT INTO ordem_servico(marca, modelo, tipo, problema, status, data_entrada, data_saida, total, id_cliente, id_mecanico, ativo) VALUES ('Marca3', 'Modelo3', 'Tipo3', 'Problema3', 'Fechada', '6-9-2023', '10-9-2023',100, 3, 1, false);
INSERT INTO ordem_servico(marca, modelo, tipo, problema, status, data_entrada, data_saida,total, id_cliente, id_mecanico, ativo) VALUES ('Marca3', 'Modelo3', 'Tipo3', 'Problema3', 'Fechada', '9-9-2023','12-9-2023',12.4, 2, 2, false);


-- INSERT PRODUTO CUSTO --
INSERT INTO produto_custo(nome) VALUES ('gasolina');
INSERT INTO produto_custo(nome) VALUES ('óleo');
INSERT INTO produto_custo(nome) VALUES ('horas de trabalho');


-- INSERT CUSTOS --
INSERT INTO custos(id_produtocusto, valor, id_ordemservico) VALUES (1, 20.0, 5);
INSERT INTO custos(id_produtocusto, valor, id_ordemservico) VALUES (2, 10.0, 5);
INSERT INTO custos(id_produtocusto, valor, id_ordemservico) VALUES (3, 100.00, 5);
INSERT INTO custos(id_produtocusto, valor, id_ordemservico) VALUES (1, 5.0, 6);
INSERT INTO custos(id_produtocusto, valor, id_ordemservico) VALUES (2, 15.0, 6);
INSERT INTO custos(id_produtocusto, valor, id_ordemservico) VALUES (3, 120.00, 6);
INSERT INTO custos(id_produtocusto, valor, id_ordemservico) VALUES (1, 13.0, 7);
INSERT INTO custos(id_produtocusto, valor, id_ordemservico) VALUES (2, 15.0, 7);
INSERT INTO custos(id_produtocusto, valor, id_ordemservico) VALUES (3, 140.00, 7);
INSERT INTO custos(id_produtocusto, valor, id_ordemservico) VALUES (1, 3.0, 8);
INSERT INTO custos(id_produtocusto, valor, id_ordemservico) VALUES (2, 44.0, 8);
INSERT INTO custos(id_produtocusto, valor, id_ordemservico) VALUES (3, 10.00, 8);



