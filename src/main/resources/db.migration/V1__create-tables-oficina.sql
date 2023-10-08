
CREATE TABLE mecanico(
                         id_mecanico serial unique primary key,
                         salario numeric(10,5),
                         nome varchar(100),
                         cpf varchar(14)

);

CREATE TABLE cliente(
                        id_cliente serial unique primary key,
                        telefone varchar(20),
                        nome varchar(100),
                        cpf varchar(14)


);

CREATE TABLE usuario(
                        id_usuario serial unique primary key,
                        login varchar(100),
                        senha varchar(100),
                        permissao varchar(20),
                        fk_id_cliente int,
                        fk_id_mecanico int,
                        FOREIGN KEY (fk_id_cliente) REFERENCES cliente (id_cliente),
                        FOREIGN KEY (fk_id_mecanico) REFERENCES mecanico (id_mecanico)

);


CREATE TABLE ordem_servico(
                              id serial unique primary key,
                              marca varchar(50),
                              modelo varchar(50),
                              tipo varchar(50),
                              problema varchar(100),
                              status varchar(20),
                              data_entrada DATE,
                              data_saida DATE,
                              total numeric(10,5),
                              ativo boolean,
                              id_cliente int,
                              id_mecanico int,
                              FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente),
                              FOREIGN KEY (id_mecanico) REFERENCES mecanico (id_mecanico)
);




CREATE TABLE produto_custo (
                               id serial unique primary key,
                               nome varchar(30)
);

CREATE TABLE custos (
                        id serial unique primary key,
                        valor numeric(10,5),
                        id_ordemservico int,
                        id_produtocusto int,
                        FOREIGN KEY (id_produtocusto) REFERENCES produto_custo (id),
                        FOREIGN KEY (id_ordemservico) REFERENCES ordem_servico (id));

