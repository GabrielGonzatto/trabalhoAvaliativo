CREATE TABLE usuario(
                        idUsuario serial unique primary key,
                        nome varchar(100),
                        cpf varchar(14),
                        login varchar(100),
                        senha varchar(100),
                        permissao varchar(20)
);

CREATE TABLE cliente(
                        idCliente int unique primary key,
                        telefone varchar(20),
                        FOREIGN KEY (idCliente) REFERENCES usuario (idUsuario)
);

CREATE TABLE mecanico(
                         idMecanico int unique primary key,
                         salario numeric(10,5),
                         FOREIGN KEY (idMecanico) REFERENCES usuario (idUsuario)
);

CREATE TABLE ordemServico(
                             idOrdem serial unique primary key,
                             marca varchar(50),
                             modelo varchar(50),
                             tipo varchar(50),
                             problema varchar(100),
                             status varchar(20),
                             dataEntrada DATE,
                             idCliente int,
                             idMecanico int,
                             FOREIGN KEY (idCliente) REFERENCES cliente (idCliente),
                             FOREIGN KEY (idMecanico) REFERENCES mecanico (idMecanico)
);

CREATE TABLE ordemServicoEncerrada (
                                       idOrdemEncerrada serial unique primary key,
                                       dataSaida DATE,
                                       total numeric(10,5),
                                       idMecanico int,
                                       idOrdem int,
                                       FOREIGN KEY (idMecanico) REFERENCES mecanico (idMecanico),
                                       FOREIGN KEY (idOrdem) REFERENCES ordemServico (idOrdem)
);

CREATE TABLE custos (
                        idcustos serial unique primary key,
                        nomeCusto varchar(30),
                        valor numeric(10,5),
                        idOrdemEncerrada int,
                        FOREIGN KEY (idOrdemEncerrada) REFERENCES ordemServicoEncerrada (idOrdemEncerrada)
);