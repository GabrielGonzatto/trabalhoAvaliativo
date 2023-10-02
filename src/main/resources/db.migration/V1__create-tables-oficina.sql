CREATE TABLE usuario(
                        id_usuario int unique primary key,
                        nome varchar(100),
                        cpf varchar(14),
                        login varchar(100),
                        senha varchar(100),
                        permissao varchar(20)
);

CREATE TABLE cliente(
                        id_cliente serial unique primary key,
                        nome varchar(100),
                        cpf varchar(14),
                        login varchar(100),
                        senha varchar(100),
                        permissao varchar(20),
                        telefone varchar(20)
);

CREATE TABLE mecanico(
                         id_mecanico serial unique primary key,
                         nome varchar(100),
                         cpf varchar(14),
                         login varchar(100),
                         senha varchar(100),
                         permissao varchar(20),
                         salario numeric(10,5)
);

CREATE TABLE ordemServico(
                             id_ordem serial unique primary key,
                             marca varchar(50),
                             modelo varchar(50),
                             tipo varchar(50),
                             problema varchar(100),
                             status varchar(20),
                             dataEntrada DATE,
                             id_cliente int,
                             id_mecanico int,
                             FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente),
                             FOREIGN KEY (id_mecanico) REFERENCES mecanico (id_mecanico)
);

CREATE TABLE ordemServicoEncerrada (
                                       id_ordemencerrada serial unique primary key,
                                       dataSaida DATE,
                                       total numeric(10,5),
                                       id_mecanico int,
                                       id_ordem int,
                                       FOREIGN KEY (id_mecanico) REFERENCES mecanico (id_mecanico),
                                       FOREIGN KEY (id_ordem) REFERENCES ordemServico (id_ordem)
);

CREATE TABLE produtoCusto (
                              id_produtocusto serial unique primary key,
                              nomeCusto varchar(30)
);

CREATE TABLE custos (
                        id_custos serial unique primary key,
                        valor numeric(10,5),
                        id_ordemencerrada int,
                        id_produtocusto int,
                        FOREIGN KEY (id_produtocusto) REFERENCES produtoCusto (id_produtocusto),
                        FOREIGN KEY (id_ordemencerrada) REFERENCES ordemServicoEncerrada (id_ordemencerrada));