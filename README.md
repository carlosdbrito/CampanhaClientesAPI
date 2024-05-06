# API Rest para Controle de Campanha de Clientes
### Essa API Rest é desenvolvida em Java e Framework Spring Boot, acessando Banco de dados PostgreSql via Docker

## Seguir os seguintes passos para execução da API Rest

1) Efetuar o dowload dessa aplicação em sua estação de trabalho, conforme procedimentos padrões do github, como git clone. 

2) Executar Container Docker de uma Imagem do banco de Dados PostgreSql, no qual as configurações como
username e password estão no arquivo application.properties dessa API. 	

3) Executar a API Rest de preferência na IDE Eclipse no qual foi desenvolvida. (As dependências serão baixadas conforme configuração do arquivo pom.xml).

4) Abrir o Browser no seguinte endereço para acessar o Swagger: http://localhost:8081/swagger-ui/index.html

5) Os Endpoints estarão disponíveis para consumo, conforme requisitos e funcionalidades solicitadas. 

## As seguintes tecnologias foram utilizadas para desenvolvimento dessa API

- Java 21 (Oracle JDK 21) 
- Spring Boot (Versão 3.1.11)
- JPA/Hibernate para persistência de dados
- Maven
- Banco de dados PostgreSQL via imagem Docker
- Utilização de segurança JWT
- Documentação da API Rest utilizando a biblioteca OpenAPI (Swagger)

## Objetivo e regras de negócio que essa API Rest atende:

  A API Rest gerencia um sistema de cadastro de Campanha de promoções para Clientes de uma instituição financeira e seu respectivo Benefício, onde cada Cliente pode ter um Benefício. 
  
  O relacionamento do Cliente com o Benefício ficará a cargo da entidade Benefício, no qual ela terá o Código de Cliente. O principal objetivo é permitir que operações CRUD (Criar, Ler, Atualizar, Deletar) sejam realizadas na estrutura de Cliente e Benefício.
  
## Segue abaixo o Modelo de Banco de Dados:

![Modelo do Banco de Dados](https://raw.githubusercontent.com/carlosdbrito/Assets/main/ModeloCampanhaClientes.png)

## Interface para execução das operações CRUD através do Swagger

- Através do endereço http://localhost:8081/swagger-ui/index.html, será exibida a seguinte tela:

![PaginaSwagger](https://raw.githubusercontent.com/carlosdbrito/Assets/main/SwaggerSistemaCadastroAPI.png)

##Procedimento para obter o Token de segurança para executar as operações CRUD

Nos EndPoints disponibilizados, localize Segurança. Clique no botão Get /token - Solicitar token de acesso. 
Informar um nome para o Parâmetro username, por exemplo: Francisco e clique no botão Execute.
No Response Body retornado, copie o Token gerado, localize o botão Authorize e insira o Token de autorização.
  

##Exemplos de dados a serem postados no formato Json, para as execuções das operações CRUD:

##  CLIENTE

###	POST /api/clientes (Cria um novo Cliente)
###	http://localhost:8081/api/clientes
	
	Request body:
	{  
	  "nome": "Mario Roberto",
	  "agencia": "2211",
	  "conta": "333877",
	  "tipoConta": "ContaCorrente",
	  "score": 1000
	}
	
###	PUT /api/clientes/{id} (Atualiza um Cliente existente) 
###	http://localhost:8081/api/clientes

	Request body:
	
	{
	  "id": 1,
	  "nome": "Claudio Francisco",
	  "agencia": "4477",
	  "conta": "5577",
	  "tipoConta": "ContaCorrente",
	  "score": 900
	}
	
##  BENEFÍCIO
	
###	POST /api/clientes/{idPessoa}/beneficio (Adiciona um novo Benefício a um Cliente)
###	http://localhost:8081/api/clientes/{id}/beneficio

	Request body:

	{
	  "id": 0,
	  "nome": "Novo Beneficio",
	  "descricao": "Novo Beneficio para 2024",
	  "dataInicio": "2024-05-06",
	  "dataFim": "2024-12-06",
	  "cliente": {
	    "id": 5,
	    "nome": "Mario Roberto",
	    "agencia": "2211",
	    "conta": "333877",
	    "tipoConta": "Poupanca",
	    "score": 900
	  }
	}


Observação: Haverá alguns EndPoints que somente será necessário informar um ID válido, como por exemplo: 
### DELETE /api/beneficio/{idBeneficio} (Remove um Beneficio por ID) 
### http://localhost:8081/api/beneficio/1

Na pasta do projeto src/main/resources/test-documents há o documento Roteiro_EvidenciaTestes.docx
com um roteiro de testes e resultado esperado, para auxiliar no consumo dos EndPoints. 


 	
  	

 
 



