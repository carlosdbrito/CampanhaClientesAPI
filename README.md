# API Rest para Controle de Campanha de Clientes
### A API Rest é desenvolvida em Java e Framework Spring Boot, acessando Banco de dados PostgreSql via Docker

## Seguir os seguintes passos para execução da API Rest

1) Efetuar o dowload dessa aplicação em sua estação de trabalho. 
2) Executar Container Docker de uma Imagem do banco de Dados PostgreSql, com as seguintes configurações:
	username: admin
	password: admin
3) Executar a API Rest de preferência na IDE Eclipse no qual foi desenvolvida
4) Abrir o Browser no seguinte endereço para acessar o Swagger: http://localhost:8081/swagger-ui/index.html

## As seguintes tecnologias foram utilizadas para desenvolvimento dessa API

- Java 21 (Oracle JDK 21) 
- Spring Boot (Versão 3.1.11)
- JPA/Hibernate para persistência de dados
- Banco de dados PostgreSQL via Docker
- Utilização de segurança JWT
- Documentação da API Rest utilizando a biblioteca OpenAPI (Swagger)

## Objetivo e regras de negócio que essa API Rest atende:

  A API Rest gerencia um sistema de cadastro de Campanha de promoções para Clientes de uma instituição financeira e seu respectivo Benefício, onde cada Cliente pode ter um Benefício. 
  
  O relacionamento do Cliente para com o Benefício ficará a cargo da entidade Benefício, onde ela terá o código de Cliente. O principal objetivo é permitir que operações CRUD (Criar, Ler, Atualizar, Deletar) sejam realizadas na estrutura de Cliente e Benefício.
  
## Segue abaixo o Modelo de Banco de Dados:

![Modelo do Banco de Dados](https://raw.githubusercontent.com/carlosdbrito/Assets/main/ModeloBancoDados.png)

## Interface para execução das operações CRUD através do Swagger

- Através do endereço http://localhost:8081/swagger-ui/index.html, será exibida a seguinte tela:

![PaginaSwagger](https://raw.githubusercontent.com/carlosdbrito/Assets/main/SwaggerSistemaCadastroAPI.png)

##Procedimento para obter o Token de segurança para executar as operações CRUD

##Exemplos da dados a serem postados no formato Json, para as execução das operações CRUD

 	
  	

 
 



