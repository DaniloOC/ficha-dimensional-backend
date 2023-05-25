CREATE TABLE produto (
	id SERIAL PRIMARY KEY,
	nome varchar(252) not null,
	descricao varchar(252),
	quantidade_cotas integer not null
);

INSERT INTO produto 
    (nome, descricao, quantidade_cotas) 
VALUES 
    ('Parafuso sextavado', 'Parafuso sextavado 10mm', 6);

INSERT INTO produto 
    (nome, descricao, quantidade_cotas) 
VALUES 
    ('Parafuso allen', 'Parafuso allen 10mm', 6);
