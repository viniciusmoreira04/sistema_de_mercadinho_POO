CREATE DATABASE mercadinho;

USE mercadinho;

CREATE TABLE usuarios (
id_usuario INTEGER PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(45) NOT NULL,
senha VARCHAR(45) NOT NULL
);

INSERT INTO usuarios (nome, senha) VALUES ("admin", "admin");

CREATE TABLE produtos (
id_produto INTEGER PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(100) NOT NULL,
preco VARCHAR(90) NOT NULL,
quantidade VARCHAR(150) NOT NULL
);