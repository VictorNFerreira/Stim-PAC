<html>
<body>
<h2>Hello World!</h2>

DROP DATABASE IF EXISTS lojajogos;
CREATE DATABASE IF NOT EXISTS lojajogos;
USE lojajogos;

CREATE TABLE conta
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    saldo DECIMAL NOT NULL DEFAULT 0

);

CREATE TABLE biblioteca
(
    id INT NOT NULL PRIMARY KEY,
    quantidade_itens INT NOT NULL DEFAULT 0,
    FOREIGN KEY(id) REFERENCES conta(id) ON DELETE RESTRICT ON UPDATE CASCADE

);

CREATE TABLE compra
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    conta_id INT,
    valor DECIMAL NOT NULL,
    forma_de_pagamento VARCHAR(20) NOT NULL,
    FOREIGN KEY(conta_id) REFERENCES conta(id) ON DELETE RESTRICT ON UPDATE CASCADE

);

CREATE TABLE empresa
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL


);

SELECT * FROM conta;
SELECT * FROM biblioteca;
SELECT * FROM compra;
SELECT * FROM empresa;


</body>
</html>
