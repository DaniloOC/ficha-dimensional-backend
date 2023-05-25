--MAQUINAS
CREATE TABLE maquina (
	id SERIAL PRIMARY KEY,
	nome varchar(252) not null,
	descricao varchar(252)
);

INSERT INTO maquina 
    (nome, descricao) 
VALUES 
    ('Fresa', 'Fresadora vertical');

INSERT INTO maquina 
    (nome, descricao) 
VALUES 
    ('Torno', 'Torno CNC');

--SETORES
CREATE TABLE setor (
	id SERIAL PRIMARY KEY,
	nome varchar(252) not null,
	descricao varchar(252)
);

INSERT INTO setor 
    (nome, descricao) 
VALUES 
    ('Corte', 'Corte');

INSERT INTO setor 
    (nome, descricao) 
VALUES 
    ('Desbaste', 'Desbaste');

--FUNCIONARIOS
CREATE TABLE funcionario (
	id SERIAL PRIMARY KEY,
	nome varchar(252) not null,
	cpf varchar(11) not null
);

INSERT INTO funcionario 
    (nome, cpf) 
VALUES 
    ('João Teste 1', '10054838096');

INSERT INTO funcionario 
    (nome, cpf) 
VALUES 
    ('João Teste 2', '87508472012');

--INSTRUMENTOS
CREATE TABLE instrumento (
	id SERIAL PRIMARY KEY,
	nome varchar(252) not null,
	descricao varchar(252)
);

INSERT INTO instrumento 
    (nome, descricao) 
VALUES 
    ('Paquímetro', 'Paquímetro Digital');

INSERT INTO instrumento 
    (nome, descricao) 
VALUES 
    ('Micrômetro', 'Micrômetro Externo');
