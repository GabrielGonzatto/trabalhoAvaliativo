-- INSERT USUÁRIO --
INSERT INTO usuario (nome, cpf, login, senha, permissao) VALUES ('Usuario1', '111.111.111-11', 'Usuario1', '12345', '1');
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
INSERT INTO cliente (idCliente, telefone) VALUES (1, '(55) 1 1111-1111');
INSERT INTO cliente (idCliente, telefone) VALUES (2, '(55) 2 2222-2222');
INSERT INTO cliente (idCliente, telefone) VALUES (3, '(55) 3 3333-3333');
INSERT INTO cliente (idCliente, telefone) VALUES (4, '(55) 4 4444-4444');
INSERT INTO cliente (idCliente, telefone) VALUES (5, '(55) 5 5555-5555');
INSERT INTO cliente (idCliente, telefone) VALUES (6, '(55) 6 6666-6666');
INSERT INTO cliente (idCliente, telefone) VALUES (7, '(55) 7 7777-7777');
INSERT INTO cliente (idCliente, telefone) VALUES (8, '(55) 8 8888-8888');
INSERT INTO cliente (idCliente, telefone) VALUES (9, '(55) 9 9999-9999');
INSERT INTO cliente (idCliente, telefone) VALUES (10, '(55) 0 0000-0000');

-- INSERT MECÂNICO --
INSERT INTO mecanico (idMecanico, salario) VALUES (11, 2500.00);
INSERT INTO mecanico (idMecanico, salario) VALUES (12, 2500.00);

-- INSERT ORDEM DE SERVIÇO --
INSERT INTO ordemServico(marca, modelo, tipo, problema, status, dataEntrada, idCliente, idMecanico) VALUES ('Marca1', 'Modelo1', 'Tipo1', 'Problema1', 'Aberta', '1/9/2023', 1, NULL);
INSERT INTO ordemServico(marca, modelo, tipo, problema, status, dataEntrada, idCliente, idMecanico) VALUES ('Marca2', 'Modelo2', 'Tipo2', 'Problema2', 'Em andamento','2/9/2023', 2, 11);
INSERT INTO ordemServico(marca, modelo, tipo, problema, status, dataEntrada, idCliente, idMecanico) VALUES ('Marca3', 'Modelo3', 'Tipo3', 'Problema3', 'Fechada', '3/9/2023', 3, 12);
INSERT INTO ordemServico(marca, modelo, tipo, problema, status, dataEntrada, idCliente, idMecanico) VALUES ('Marca4', 'Modelo4', 'Tipo4', 'Problema4', 'Aberta', '4/9/2023', 4, NULL);
INSERT INTO ordemServico(marca, modelo, tipo, problema, status, dataEntrada, idCliente, idMecanico) VALUES ('Marca5', 'Modelo5', 'Tipo5', 'Problema5', 'Em andamento', '5/9/2023', 5, 11);
INSERT INTO ordemServico(marca, modelo, tipo, problema, status, dataEntrada, idCliente, idMecanico) VALUES ('Marca6', 'Modelo6', 'Tipo6', 'Problema6', 'Fechada', '6/9/2023', 6, 12);
INSERT INTO ordemServico(marca, modelo, tipo, problema, status, dataEntrada, idCliente, idMecanico) VALUES ('Marca7', 'Modelo7', 'Tipo7', 'Problema7', 'Aberta', '7/9/2023', 7, NULL);
INSERT INTO ordemServico(marca, modelo, tipo, problema, status, dataEntrada, idCliente, idMecanico) VALUES ('Marca8', 'Modelo8', 'Tipo8', 'Problema8', 'Em andamento', '8/9/2023', 8, 11);
INSERT INTO ordemServico(marca, modelo, tipo, problema, status, dataEntrada, idCliente, idMecanico) VALUES ('Marca9', 'Modelo9', 'Tipo9', 'Problema9', 'Fechada', '9/9/2023', 9 ,12);
INSERT INTO ordemServico(marca, modelo, tipo, problema, status, dataEntrada, idCliente, idMecanico) VALUES ('Marca10', 'Modelo10', 'Tipo10', 'Problema10', 'Aberta', '10/9/2023', 10, NULL);
INSERT INTO ordemServico(marca, modelo, tipo, problema, status, dataEntrada, idCliente, idMecanico) VALUES ('Marca11', 'Modelo11', 'Tipo11', 'Problema11', 'Em andamento', '11/9/2023', 1, 11);
INSERT INTO ordemServico(marca, modelo, tipo, problema, status, dataEntrada, idCliente, idMecanico) VALUES ('Marca12', 'Modelo12', 'Tipo12', 'Problema12', 'Fechada', '12/9/2023', 2, 12);
INSERT INTO ordemServico(marca, modelo, tipo, problema, status, dataEntrada, idCliente, idMecanico) VALUES ('Marca13', 'Modelo13', 'Tipo13', 'Problema13', 'Aberta', '13/9/2023', 3, NULL);
INSERT INTO ordemServico(marca, modelo, tipo, problema, status, dataEntrada, idCliente, idMecanico) VALUES ('Marca14', 'Modelo14', 'Tipo14', 'Problema14', 'Em andamento', '14/9/2023', 4, 11);
INSERT INTO ordemServico(marca, modelo, tipo, problema, status, dataEntrada, idCliente, idMecanico) VALUES ('Marca15', 'Modelo15', 'Tipo15', 'Problema15', 'Fechada', '15/9/2023', 5, 12);
INSERT INTO ordemServico(marca, modelo, tipo, problema, status, dataEntrada, idCliente, idMecanico) VALUES ('Marca16', 'Modelo16', 'Tipo16', 'Problema16', 'Aberta', '16/9/2023', 6, NULL);
INSERT INTO ordemServico(marca, modelo, tipo, problema, status, dataEntrada, idCliente, idMecanico) VALUES ('Marca17', 'Modelo17', 'Tipo17', 'Problema17', 'Em andamento', '17/9/2023', 7, 11);
INSERT INTO ordemServico(marca, modelo, tipo, problema, status, dataEntrada, idCliente, idMecanico) VALUES ('Marca18', 'Modelo18', 'Tipo18', 'Problema18', 'Fechada', '18/9/2023', 8, 12);
INSERT INTO ordemServico(marca, modelo, tipo, problema, status, dataEntrada, idCliente, idMecanico) VALUES ('Marca19', 'Modelo19', 'Tipo19', 'Problema19', 'Aberta', '19/9/2023', 9, NULL);
INSERT INTO ordemServico(marca, modelo, tipo, problema, status, dataEntrada, idCliente, idMecanico) VALUES ('Marca20', 'Modelo20', 'Tipo20', 'Problema20', 'Em andamento', '20/9/2023', 10, 11);

-- INSERT ORDEM DE SERVIÇO ENCERRADA --
INSERT INTO ordemServicoEncerrada(dataSaida, total, idMecanico, idOrdem) VALUES ('12/9/2023', 0.0, 12, 6);
INSERT INTO ordemServicoEncerrada(dataSaida, total, idMecanico, idOrdem) VALUES ('13/9/2023', 0.0, 12, 9);
INSERT INTO ordemServicoEncerrada(dataSaida, total, idMecanico, idOrdem) VALUES ('14/9/2023', 0.0, 12, 12);
INSERT INTO ordemServicoEncerrada(dataSaida, total, idMecanico, idOrdem) VALUES ('15/9/2023', 0.0, 12, 15);
INSERT INTO ordemServicoEncerrada(dataSaida, total, idMecanico, idOrdem) VALUES ('18/9/2023', 0.0, 12, 18);

-- INSERT PRODUTO CUSTO --
INSERT INTO produtoCusto(nomeCusto) VALUES ('gasolina');
INSERT INTO produtoCusto(nomeCusto) VALUES ('óleo');
INSERT INTO produtoCusto(nomeCusto) VALUES ('horas de trabalho');


-- INSERT CUSTOS --
INSERT INTO custos(idProdutoCusto, valor, idOrdemEncerrada) VALUES (1, 0.0, 1);
INSERT INTO custos(idProdutoCusto, valor, idOrdemEncerrada) VALUES (2, 0.0, 1);
INSERT INTO custos(idProdutoCusto, valor, idOrdemEncerrada) VALUES (3, 100.00, 1);
INSERT INTO custos(idProdutoCusto, valor, idOrdemEncerrada) VALUES (1, 0.0, 2);
INSERT INTO custos(idProdutoCusto, valor, idOrdemEncerrada) VALUES (2, 0.0, 2);
INSERT INTO custos(idProdutoCusto, valor, idOrdemEncerrada) VALUES (3, 100.00, 2);
INSERT INTO custos(idProdutoCusto, valor, idOrdemEncerrada) VALUES (1, 0.0, 3);
INSERT INTO custos(idProdutoCusto, valor, idOrdemEncerrada) VALUES (2, 0.0, 3);
INSERT INTO custos(idProdutoCusto, valor, idOrdemEncerrada) VALUES (3, 100.00, 3);
INSERT INTO custos(idProdutoCusto, valor, idOrdemEncerrada) VALUES (1, 0.0, 4);
INSERT INTO custos(idProdutoCusto, valor, idOrdemEncerrada) VALUES (2, 0.0, 4);
INSERT INTO custos(idProdutoCusto, valor, idOrdemEncerrada) VALUES (3, 100.00, 4);
INSERT INTO custos(idProdutoCusto, valor, idOrdemEncerrada) VALUES (1, 0.0, 5);
INSERT INTO custos(idProdutoCusto, valor, idOrdemEncerrada) VALUES (2, 0.0, 5);
INSERT INTO custos(idProdutoCusto, valor, idOrdemEncerrada) VALUES (3, 100.00, 5);


