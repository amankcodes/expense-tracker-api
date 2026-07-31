# AI_NOTES.md

# AI Usage Notes

## AI Tools Used

- ChatGPT

---

## 1. AI-generated vs. Self-written

AI was used as a development assistant throughout the assignment to accelerate development and review implementation decisions.

AI assisted with:

- Initial project structure and package organization
- REST API design suggestions
- Service layer implementation
- Exception handling approach
- Unit test structure
- Swagger integration guidance
- Documentation drafting

The following work was completed manually:

- Creating and configuring the Spring Boot project
- Writing, integrating, and organizing the project files
- Resolving compilation and dependency issues
- Implementing and refining business logic
- Updating the implementation based on testing
- Running the application and validating all endpoints
- Executing and verifying unit tests
- Preparing the final project structure for submission

---

## 2. Validation, Testing and Improvements

AI-generated suggestions were reviewed before being incorporated.

The following manual validation and improvements were performed:

- Verified every REST endpoint using Postman
- Fixed validation issues after changing the date field from String to LocalDate
- Implemented automatic ID generation using AtomicLong instead of accepting IDs from the client
- Added request validation using Jakarta Validation
- Implemented centralized exception handling using @RestControllerAdvice
- Added Swagger/OpenAPI documentation
- Executed and verified all unit tests
- Improved API behavior to better follow REST principles
- Updated the README to include installation, execution, testing instructions, and sample API requests

---

## 3. AI Suggestions Not Used

Some AI suggestions were intentionally not implemented because they were outside the assignment scope.

These include:

- Database integration (the assignment explicitly allowed in-memory storage)
- Authentication and authorization
- Repository layer and JPA persistence
- DTO mapping
- Docker containerization
- Additional reporting or analytics features beyond the required functionality

These decisions were made to keep the implementation focused on the assignment requirements while maintaining clean and readable code.

---

## 4. Development Approach

AI was used as an engineering assistant rather than a replacement for implementation.

Every code change was reviewed, integrated, compiled, tested, and verified before being included in the final submission.
