# API de Marketplace (Case FourSales)

Esta é uma API RESTful completa desenvolvida em Spring Boot que simula o backend de um sistema de marketplace (e-commerce). O projeto foi construído como parte de um teste técnico e inclui gerenciamento de produtos, um fluxo de pedidos complexo e autenticação de usuários baseada em JWT (JSON Web Token).

O sistema utiliza Spring Data JPA para persistência de dados em um banco MySQL, com consultas otimizadas para relatórios.

---

## ✨ Funcionalidades Principais

* **Autenticação e Autorização:**
    * Sistema de login seguro usando Spring Security e JWT.
    * Controle de acesso baseado em perfis (Roles): `ADMIN` e `USER`.
* **Gerenciamento de Pedidos (Orders):**
    * Criação de pedidos com múltiplos produtos (itens).
    * Validação de estoque no momento da criação (salva como `CANCELADO` se o estoque for insuficiente).
    * Endpoint de "Pagamento" que valida o estoque novamente e o abate, mudando o status para `APROVADO`.
    * Listagem de pedidos por usuário autenticado.
* **Gerenciamento de Produtos (Products):**
    * CRUD completo de produtos (protegido para `ADMIN`).
* **Relatórios Otimizados (Estatísticas):**
    * Endpoint para Top 5 usuários que mais compraram (valor).
    * Endpoint para Ticket Médio (valor médio de pedido) de cada usuário.
    * Endpoint para Faturamento Total do mês corrente.
* **População de Dados (Seeder):**
    * A aplicação popula o banco de dados automaticamente na primeira inicialização com dados de teste (usuários, produtos e pedidos). Porém existe um dump na pasta src/main/resources/dump20251112

---

## 🛠️ Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3.x**
* **Spring Security 6 (JWT):** Para autenticação e autorização.
* **Spring Data JPA (Hibernate):** Para persistência de dados.
* **MySQL 8.0+:** Banco de dados relacional.
* **Maven:** Gerenciador de dependências.

---

## 🚀 Como Executar o Projeto

### Pré-requisitos

* **JDK 21** (ou superior)
* **Maven 3.8+**
* **MySQL Server 8.0+**
* (Opcional) Uma IDE (IntelliJ, VSCode) e um cliente de API (Postman, Insomnia).

### 1. Configuração do Banco de Dados

1.  **Crie o Schema:** A aplicação requer um banco de dados (schema) chamado `Market`. Conecte-se ao seu MySQL e execute:
    ```sql
    CREATE DATABASE Market;
    ```

2.  **Configure a Senha:** Abra o arquivo `src/main/resources/application.properties`. Você **deve** atualizar a senha do banco de dados para corresponder à sua instalação local do MySQL.

    ```properties
    # Atualize esta linha com sua senha root
    spring.datasource.password=SUA_SENHA_AQUI
    ```

### 2. Executando a Aplicação

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/FelipeB4C/case-foursales.git](https://github.com/FelipeB4C/case-foursales.git)
    cd case-foursales
    ```

2.  **Execute via Maven:**
    ```bash
    mvn spring-boot:run
    ```

3.  (Alternativa) **Execute pela IDE:** Abra o projeto na sua IDE, aguarde o Maven baixar as dependências e execute a classe principal `CaseApplication.java`.

A aplicação estará disponível em `http://localhost:8080`.

### 3. População de Dados (Seeder)

Na **primeira vez** que a aplicação iniciar, ela executará o `CommandLineRunner` (dentro da `CaseApplication`) e populará o banco com:
* 6 Usuários (1 ADMIN, 5 USERs)
* 7 Produtos
* 10 Pedidos (com status `APROVADO` ou `PENDENTE`)

> **Nota:** O *seeder* só é executado se a tabela `users` estiver vazia. Para executá-lo novamente, limpe a tabela `users` (`TRUNCATE TABLE users;`) e reinicie a aplicação.

---

## 🔑 Autenticação (Login)

Para acessar os *endpoints* protegidos, você deve primeiro obter um token JWT.

Usuário comuns podem listar produtos, fazer pedidos e pagamentos.
Administradores podem fazer CRUD em produtos e também acessar as estatisticas.

#### `POST /auth/login`

**Request Body ADMIN:**
```json
{
    "login": "admin.user",
    "password": "admin"
}
```

**Request Body NORMAL USER:**
```json
{
    "login": "normal.user",
    "password": "normal"
}
```

Para facilitar as requisições, o projeto possui uma collection para ser importada que está em src/main/resources/collection-case.har

Você deverá ter configurado em seu postman/insomnia a seguinte variável global para facilitar autenticação

```json
{
	"jwt_token": "{% response 'body', 'req_ec2addb55488468f987b017247997064', 'b64::JC50b2tlbg==::46b', 'never', 60 %}"
}
```