# Desafio TQI

Desafio proposto pela TQI, para criação de um sistema simples de solicitação e acompanhamento de Empréstimo.

## Tecnologias e Ferramentas
 - Java 8
 - Maven
 - Spring boot
 - Banco H2 (Banco em Memória)
 - Intellij IDEA

## Funcionalidades
  - Cadastro de Clientes;
  - Login;
  - Solicitação de Empréstimo;
  - Acompanhamento de Empréstimo.

## Endpoint Client (Cliente)

### Cadastro de Clientes
Através do Endpoint `clients` e da rota `/add-clients`, com a utilização do método POST, é possível realizar o Cadastro de Clientes, informando seu NOME, EMAIL e SENHA. Antes de concluir o cadastro, é verificado se o e-mail solicitado não está cadastrado e a senha é criptografada usando Hash MD5.

### Login

Através do Endpoint `clients` e da rota `/login`, com a utilização do método POST, é possível realizar o Login, informando seu EMAIL e SENHA. Os dados são validados e o sistema retorna e salva o Acess Token (atualmente apenas um Hash MD5) do Cliente.

## Endpoint Loan (Empréstimo)
### Solicitaçao de Empréstimo

Através do Endpoint `loans` e da rota `/add-loan`, com a utilização do método POST, é possível realizar a Solicitação (Cadastro) de Empréstimos, informando o ID DO CLIENTE, NOME DO EMPRÉSTIMO e VALOR. Antes de concluir o cadastro, é verificado se o CLIENTE está cadastrado. Todos os empréstimos são cadastrados com o status PENDING_APROVATION, para aprovação posterior da empresa.

### Consulta de Empréstimo

Através do Endpoint `loans` e da rota `/findByClientId/{id}`, com a utilização do método GET, é possível realizar o Acompanhamento das Propostas, informando o ID DO CLIENTE.
