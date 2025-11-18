# User Management API

A senior-level backend project built with **Java 17**, **Spring Boot
3.3**, **PostgreSQL**, **Docker**, and **JPA**.

------------------------------------------------------------------------

## 📦 Technologies Used

-   Java 17
-   Spring Boot 3.3
-   Spring Web
-   Spring Security (Basic Auth)
-   Spring Data JPA
-   Hibernate
-   PostgreSQL
-   Docker & Docker Compose
-   JUnit 5
-   Swagger / OpenAPI

------------------------------------------------------------------------

## 🚀 Running the Project

### ✔️ 1. **Build the project locally**

``` bash
./mvnw clean package
```

Gerará:

    target/user-management-1.0.0.jar

------------------------------------------------------------------------

## 🐳 Running with Docker

### ✔️ 2. **Build and run using Docker Compose**

``` bash
docker-compose build
docker-compose up
```

A API ficará acessível em:

    http://localhost:8080

------------------------------------------------------------------------

## 🔐 Authentication

A API utiliza **Basic Auth**.

Credenciais padrão (definidas em `application.yml`):

    user: apiuser
    pass: apipass

------------------------------------------------------------------------

## 🧪 Running tests

``` bash
./mvnw test
```

Ou com docker (fazendo build completo):

``` bash
docker run -it --rm user-management mvn test
```

------------------------------------------------------------------------

## 📘 Swagger UI

Disponível em:

    http://localhost:8080/swagger-ui/index.html

------------------------------------------------------------------------

## 🛠 Endpoints principais

### Criar usuário

    POST /users

### Buscar usuário

    GET /users/{id}

### Atualizar usuário

    PATCH /users/{id}

### Deletar usuário

    DELETE /users/{id}

### Adicionar projeto externo

    POST /users/{userId}/projects

### Listar projetos externos

    GET /users/{userId}/projects

------------------------------------------------------------------------

## 📂 Project Structure

    src/
     └── main/
          ├── java/com/example/usermgmt/
          │    ├── config/
          │    ├── controller/
          │    ├── dto/
          │    ├── entity/
          │    ├── exception/
          │    ├── repository/
          │    └── service/
          └── resources/
               ├── application.yml
               └── logback-spring.xml

------------------------------------------------------------------------

## 💡 Notes

-   Docker Compose inclui o PostgreSQL automaticamente.
-   O banco é acessível como: `jdbc:postgresql://db:5432/demo
-   Os testes unitários utilizam Mockito e WebMvcTest.

------------------------------------------------------------------------

## 📄 License

MIT License.
