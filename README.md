# student-employee-project

Gradle + Spring Boot + PostgreSQL test application intentionally designed for CodeIntelligence regression testing.

Core endpoint: `/api/persons` with `type` = `EMPLOYEE` or `STUDENT`. Shared child mappers: `EmailDetailsMapper`, `ContactDetailsMapper`, `AddressMapper`.

Baseline intentionally does NOT contain `employmentType` or contact `countryCode`; those are added later in the regression exercises.
