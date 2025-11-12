# JavaCRM_SpringBoot# 🚀 Mini-CRM API com Spring Boot

Um projeto de API simples para um (Mini-CRM) que permite o gerenciamento de clientes e seus respectivos contatos. Este projeto foi construído em Java 17+ utilizando o framework Spring Boot.

## ✨ Sobre o Projeto

O objetivo deste projeto é fornecer uma API RESTful básica para operações CRUD (Criar, Ler) em entidades de `Cliente` e `Contato`.

* Um **Cliente** pode ter vários **Contatos**.
* Um **Contato** (ex: telefone, e-mail secundário) pertence a um único **Cliente**.

---

## 🛠️ Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot 3+**
* **Spring Web:** Para criação de endpoints RESTful.
* **Spring Data JPA:** Para persistência de dados e comunicação com o banco.
* **H2 Database:** (Configuração sugerida para desenvolvimento) Banco de dados em memória.
* **Lombok:** Para reduzir código boilerplate (como Getters, Setters, etc.).
* **Maven/Gradle:** Gerenciador de dependências.

---

## 🌟 Funcionalidades Principais

* Criar novos clientes.
* Listar todos os clientes cadastrados.
* Adicionar contatos a um cliente existente.
* Listar todos os contatos de um cliente específico.

---

## <caption> API Endpoints

Abaixo estão os endpoints disponíveis na API:

### Clientes

#### `POST /clientes`

Cria um novo cliente.

* **Request Body:**
    ```json
    {
      "nome": "Ada Lovelace",
      "email": "ada.lovelace@example.com"
    }
    ```
* **Response:** `201 Created`
    ```json
    {
      "id": 1,
      "nome": "Ada Lovelace",
      "email": "ada.lovelace@example.com",
      "contatos": []
    }
    ```

#### `GET /clientes`

Lista todos os clientes cadastrados.

* **Response:** `200 OK`
    ```json
    [
      {
        "id": 1,
        "nome": "Ada Lovelace",
        "email": "ada.lovelace@example.com",
        "contatos": [
          {
            "id": 1,
            "tipo": "Telefone",
            "Valor": "(11) 98765-4321"
          }
        ]
      }
    ]
    ```

---

### Contatos

#### `POST /clientes/{id}/contatos`

Adiciona um novo contato a um cliente específico, usando o `id` do cliente.

* **Request Body:**
    ```json
    {
      "tipo": "Telefone",
      "Valor": "(11) 98765-4321"
    }
    ```
    *(Atenção: O campo é `Valor` com 'V' maiúsculo, conforme o Model `Contato.java`)*

* **Response:** `201 Created`
    ```json
    {
      "id": 1,
      "tipo": "Telefone",
      "Valor": "(11) 98765-4321"
    }
    ```

#### `GET /clientes/{id}/contatos`

Lista todos os contatos de um cliente específico.

* **Response:** `200 OK`
    ```json
    [
      {
        "id": 1,
        "tipo": "Telefone",
        "Valor": "(11) 98765-4321"
      },
      {
        "id": 2,
        "tipo": "Email Secundário",
        "Valor": "ada.work@example.com"
      }
    ]
    ```

---

## ⚙️ Como Executar Localmente

### Pré-requisitos

* Java (JDK 17 ou superior)
* Maven ou Gradle
* Uma IDE (ex: IntelliJ, VS Code) ou a linha de comando.

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
    cd seu-repositorio
    ```

2.  **Configuração do Banco de Dados:**
    O projeto está configurado para usar o H2 (banco em memória) por padrão, o que não requer instalação. Se você quiser usar outro banco (como PostgreSQL ou MySQL), atualize o arquivo `src/main/resources/application.properties` com suas credenciais.

    *Exemplo de `application.properties` para H2 (usado por padrão):*
    ```properties
    # H2 Database Configuration
    spring.datasource.url=jdbc:h2:mem:minicrmdb
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.username=sa
    spring.datasource.password=password
    spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

    # H2 Console
    spring.h2.console.enabled=true
    spring.h2.console.path=/h2-console

    # JPA Settings
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

3.  **Execute o projeto (usando Maven):**
    ```bash
    mvn spring-boot:run
    ```

4.  **Acesse a aplicação:**
    A API estará disponível em `http://localhost:8080`.

    Se você usou a configuração do H2 acima, pode acessar o console do banco em `http://localhost:8080/h2-console` (use a URL JDBC `jdbc:h2:mem:minicrmdb`).

---

