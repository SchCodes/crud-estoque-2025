# CRUD Estoque 2025

Aplicação desktop em Java Swing para gerenciar estoque, compras e vendas. O projeto segue o padrão DAO + Beans, usa MySQL como banco relacional e possui telas para cada entidade principal.

## Funcionalidades principais
- Cadastro completo de fornecedores, clientes, usuarios, tipos de produto e produtos
- Fluxos de compra e venda com integração ao estoque
- Menus desktop (MDI) para abrir cada tela dentro da `TelaPrincipal`
- Script SQL pronto para criar o banco `bd_estoque`

## Arquitetura
- Java 24 (definido em `maven.compiler.release`)
- Maven para build/gerenciamento de dependências
- Swing para a interface (arquivos `.form` e `.java` em `src/main/java/views`)
- MySQL Connector/J 8.0.33
- Classe `conexao.Conexao` centraliza configuração JDBC

## Requisitos
- JDK 21 ou superior (idealmente 24 para alinhar ao build atual)
- Maven 3.9+
- MySQL Server 8.x acessível em `localhost:3306`

## Scripts de banco
- `bd_estoque.sql` contém toda a definição das tabelas, chaves estrangeiras e relacionamentos necessários para o CRUD