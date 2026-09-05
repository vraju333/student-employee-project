# Student & Employee Test Project

A Spring Boot Java 21 project intentionally designed to test source-code analysis tools.

## Included constructs
- REST controllers
- Controller interface mappings
- Generic base controller interface
- Service interfaces
- Service implementations
- Abstract generic service class
- JPA repositories
- Entities with inheritance from an abstract `Person`
- DTO records + validation
- Global exception handler
- H2 database
- GET, POST, PUT, PATCH and DELETE endpoints
- Repository calls both through services and directly from a controller

## Run
```bash
mvn spring-boot:run
```

Open H2 console: `http://localhost:8080/h2-console`
JDBC URL: `jdbc:h2:mem:studentemployee`

## Important endpoints

### Students
- GET `/api/students`
- GET `/api/students/{id}`
- GET `/api/students/course/{course}`
- POST `/api/students`
- PUT `/api/students/{id}`
- DELETE `/api/students/{id}`

### Employees
- GET `/api/employees`
- GET `/api/employees/{id}`
- GET `/api/employees/department/{department}`
- POST `/api/employees`
- PATCH `/api/employees/{id}`
- DELETE `/api/employees/{id}`

### Cross-entity search
- GET `/api/search/person?email=...`

## Example student JSON
```json
{
  "name": "Ravi Kumar",
  "email": "ravi@student.com",
  "age": 21,
  "course": "Computer Science",
  "yearOfStudy": 3,
  "gpa": 8.7
}
```

## Example employee JSON
```json
{
  "name": "Anita Sharma",
  "email": "anita@company.com",
  "age": 31,
  "department": "Engineering",
  "designation": "Senior Developer",
  "salary": 1200000
}
```

## CodeIntelligence test cases
1. `/api/students/{id}` GET mapping is declared in `BaseReadController`, but implemented in `StudentController`.
2. `/api/students` class-level mapping is declared in `StudentApi`, not directly on `StudentController`.
3. Student flow: controller -> `StudentService` interface -> `StudentServiceImpl` -> abstract inherited method -> `StudentRepository` -> `Student` entity.
4. Employee mappings are intentionally mixed between `EmployeeApi` and `EmployeeController`.
5. `SearchController` directly calls repositories, which gives your analyzer a non-standard controller -> repository path.
