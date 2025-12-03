-- Script de criacao do banco de dados bd_estoque
DROP DATABASE IF EXISTS bd_estoque;
CREATE DATABASE bd_estoque CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE bd_estoque;

CREATE TABLE fornecedor (
  id_fornecedor INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(60) NOT NULL,
  rua VARCHAR(60),
  numero VARCHAR(10),
  telefone VARCHAR(20)
);

CREATE TABLE usuario (
  id_usuario INT AUTO_INCREMENT PRIMARY KEY,
  login VARCHAR(45) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  email VARCHAR(60)
);

CREATE TABLE tipo_produto (
  id_tipo_produto INT AUTO_INCREMENT PRIMARY KEY,
  descricao VARCHAR(60) NOT NULL
);

CREATE TABLE cliente (
  id_cliente INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(60) NOT NULL,
  rua VARCHAR(60),
  numero VARCHAR(10),
  telefone VARCHAR(20)
);

CREATE TABLE compra (
  id_compra INT AUTO_INCREMENT PRIMARY KEY,
  id_fornecedor INT NOT NULL,
  id_usuario INT NOT NULL,
  CONSTRAINT fk_compra_fornecedor FOREIGN KEY (id_fornecedor) REFERENCES fornecedor(id_fornecedor) ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT fk_compra_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE produto (
  id_produto INT AUTO_INCREMENT PRIMARY KEY,
  descricao VARCHAR(60) NOT NULL,
  valor_unitario DECIMAL(10,2) NOT NULL,
  quantidade INT NOT NULL,
  id_tipo_produto INT NOT NULL,
  CONSTRAINT fk_produto_tipo FOREIGN KEY (id_tipo_produto) REFERENCES tipo_produto(id_tipo_produto) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE venda (
  id_venda INT AUTO_INCREMENT PRIMARY KEY,
  id_cliente INT NOT NULL,
  id_usuario INT NOT NULL,
  CONSTRAINT fk_venda_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT fk_venda_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE compra_produto (
  id_compra INT NOT NULL,
  id_produto INT NOT NULL,
  quantidade INT NOT NULL,
  PRIMARY KEY (id_compra, id_produto),
  CONSTRAINT fk_compra_produto_compra FOREIGN KEY (id_compra) REFERENCES compra(id_compra) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT fk_compra_produto_prod FOREIGN KEY (id_produto) REFERENCES produto(id_produto) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE venda_produto (
  id_venda INT NOT NULL,
  id_produto INT NOT NULL,
  quantidade INT NOT NULL,
  valor_venda DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (id_venda, id_produto),
  CONSTRAINT fk_venda_produto_venda FOREIGN KEY (id_venda) REFERENCES venda(id_venda) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT fk_venda_produto_prod FOREIGN KEY (id_produto) REFERENCES produto(id_produto) ON UPDATE CASCADE ON DELETE RESTRICT
);
