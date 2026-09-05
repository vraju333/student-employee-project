# Student Employee Project

A Spring Boot Java 21 test application designed for code-analysis / CodeIntelligence testing.

It intentionally contains controller interfaces, inherited controller methods, abstract service methods,
service interfaces and implementations, JPA repositories, entities, DTOs, validation and exception handling.

## Stack

- Java 21
- Spring Boot 3.5.5
- Gradle
- Spring Web
- Spring Data JPA
- PostgreSQL
- Jakarta Validation

## Start PostgreSQL

The easiest local option is Docker:

```bash
docker compose up -d
```

This starts PostgreSQL with:

- Database: `student_employee_db`
- Username: `postgres`
- Password: `postgres`
- Port: `5432`

## Run the application

If Gradle is installed:

```bash
gradle bootRun
```

If you generate/use the Gradle wrapper:

Windows:

```bash
gradlew.bat bootRun
```

Linux/macOS:

```bash
./gradlew bootRun
```

The API starts at:

`http://localhost:8080`

## PostgreSQL configuration

Defaults are in `src/main/resources/application.properties`:

```properties
spring.datasource.url=${DB_URL:jdbc:postgresql://localhost:5432/student_employee_db}
spring.datasource.username=${DB_USERNAME:postgres}
spring.datasource.password=${DB_PASSWORD:postgres}
```

For another environment, set:

```text
DB_URL
DB_USERNAME
DB_PASSWORD
```

For example:

```text
DB_URL=jdbc:postgresql://localhost:5432/student_employee_db
DB_USERNAME=postgres
DB_PASSWORD=postgres
```

## Main code-analysis paths

### Inherited controller mapping

```text
GET /api/students/{id}
  -> BaseReadController
  -> StudentController
  -> StudentService
  -> StudentServiceImpl
  -> AbstractPersonService
  -> StudentRepository
  -> PostgreSQL
```

### Interface-declared controller mapping

```text
POST /api/students
  -> StudentApi
  -> StudentController
  -> StudentService
  -> StudentServiceImpl
  -> StudentRepository
  -> PostgreSQL
```

### Multi-repository flow

```text
GET /api/search/person?email=...
  -> SearchController
  -> StudentRepository / EmployeeRepository
  -> PostgreSQL
```

This makes the project useful for testing whether an analyzer discovers endpoint mappings across the entire Java project instead of looking only at concrete controller classes.
