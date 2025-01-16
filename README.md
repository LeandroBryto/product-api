API Restful - Gerenciamento de Produtos
Este projeto é uma API Restful implementada com Spring Boot para o gerenciamento de produtos. A API permite a realização de operações CRUD (Criar, Ler, Atualizar, Excluir) sobre os produtos. A aplicação usa o banco de dados MySQL e tem validações e logs implementados para ajudar no monitoramento das operações.

Funcionalidades
A API oferece os seguintes endpoints:

GET /product: Lista todos os produtos.
GET /{id}: Retorna o produto com o ID especificado.
POST /products: Cria um novo produto com os dados fornecidos.
PUT /{id}: Atualiza um produto existente com base no ID fornecido.
DELETE /{id}: Exclui um produto com o ID fornecido.

Tecnologias Utilizadas
Spring Boot: Framework principal para desenvolvimento da API.
JPA (Java Persistence API): Para interação com o banco de dados.
MySQL: Banco de dados utilizado para armazenar os produtos.
Swagger: Para documentar e testar a API via interface gráfica.
SLF4J + Logback: Utilizados para logging detalhado das operações.
Lombok: Biblioteca para reduzir o código boilerplate, como getters, setters.

Estrutura do Projeto
A estrutura do projeto é a seguinte:

controller: Contém as classes responsáveis pelos endpoints da API.
service: Contém as classes que implementam a lógica de negócios da aplicação.
model: Contém as classes de modelo (representação das entidades do banco de dados).
repository: Contém as interfaces que fazem a comunicação com o banco de dados.

Dependências
spring-boot-starter-data-jpa: Para interação com o banco de dados.
springdoc-openapi: Para gerar documentação Swagger.
spring-boot-starter-web: Para criar a API Restful.
spring-boot-starter-validation: Para validar os dados de entrada.
spring-boot-starter-hateoas: Para adicionar links HATEOAS nos endpoints.
Contribuindo
Sinta-se à vontade para fazer contribuições, seja sugerindo melhorias ou criando pull requests. Para contribuir, basta:

Fazer um fork do projeto.
Criar uma branch para suas alterações.
Fazer o commit e enviar suas alterações.
Criar um pull request.



