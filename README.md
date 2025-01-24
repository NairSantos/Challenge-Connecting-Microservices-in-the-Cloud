# Desafio: Conectando Microserviços na Nuvem - Banco JAVER

## Descrição

Este projeto envolve a criação de dois microserviços em Spring Boot, interconectados e hospedados na nuvem. O objetivo é gerenciar o cadastro de clientes do Banco JAVER, com funcionalidades de CRUD (Create, Read, Update, Delete) e cálculo de score de crédito, além de garantir uma cobertura de testes unitários de 100%.

## Funcionalidades

- **Primeira Aplicação**: Realiza requisições REST para a segunda aplicação e expõe endpoints CRUD para o gerenciamento de clientes. Também realiza o cálculo de score de crédito com base no saldo de conta corrente.
  
- **Segunda Aplicação**: Responsável pelo armazenamento dos dados dos clientes em um banco de dados local H2 e oferece endpoints CRUD para manipulação dos dados.

## Tecnologias Utilizadas

- **Spring Boot**: Framework principal para a criação dos microserviços.
- **H2 Database**: Banco de dados local utilizado na segunda aplicação.
- **Swagger**: Utilizado para a documentação automática da API.
- **REST**: Comunicação entre os microserviços.

## Endpoints

### Primeira Aplicação

1. **GET /servico/clientes**: Lista todos os clientes.
2. **POST /servico/clientes**: Cria um novo cliente.
3. **PUT /servico/clientes/{id}**: Atualiza o saldo de um cliente.
4. **DELETE /servico/clientes/{id}**: Deleta um cliente.

### Segunda Aplicação

1. **GET /clientes**: Retorna todos os clientes cadastrados.
2. **POST /clientes**: Cria um novo cliente.
3. **PUT /clientes/{id}**: Atualiza os dados de um cliente.
4. **DELETE /clientes/{id}**: Deleta um cliente.


# Como Executar a Aplicação

Clone este repositório para o seu ambiente local (as 2 pastas)

Executar a aplicação:

No Visual studio Code, clique em "Run" :

Acessar a API:

A API estará disponível em http://localhost:8081/clients
Como Testar a API (Postman)
Teste 1: Criar Cliente
Método: POST
URL: http://localhost:8081/clients
Corpo da Requisição:
(json)

{
    "nome": "João Silva",
    "telefone": 123456789,
    "correntista": true,
    "saldoCc": 5000.00
}
Resposta Esperada:
Status 200: Retorna os dados do cliente criado.

Teste 2: Listar Todos os Clientes
Método: GET
URL: http://localhost:8081/clients
Resposta Esperada:
Status 200: Retorna a lista de clientes cadastrados.

Teste 3: Atualizar Saldo de Conta Corrente
Método: PUT
URL: http://localhost:8081/clients/{id}?newBalance={novo saldo}
Parâmetros:
id: ID do cliente a ser atualizado
newBalance: Novo saldo a ser atribuído ao cliente.
Resposta Esperada:
Status 200: Retorna os dados do cliente com o saldo atualizado.

Teste 4: Excluir Cliente
Método: DELETE
URL: http://localhost:8081/clients/{id}
Resposta Esperada:
Status 200: Cliente removido com sucesso.


Swagger - Documentação Interativa da API
Para acessar a documentação interativa da API gerada pelo Swagger, basta abrir a URL:

http://localhost:8081/swagger-ui/index.html
Você poderá visualizar todos os endpoints disponíveis, testar a API diretamente na interface do Swagger, e ver exemplos de respostas.

