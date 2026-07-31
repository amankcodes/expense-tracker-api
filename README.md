# Smart Expense Tracker API

A RESTful Expense Tracker API built using Java and Spring Boot.

## Features

- Add an expense
- View all expenses
- Filter expenses by category
- Calculate total expenses
- Calculate category-wise total
- Delete an expense
- Input validation
- Global exception handling
- Swagger/OpenAPI documentation

## Tech Stack

- Java 21
- Spring Boot
- Maven
- JUnit 5
- Lombok

## Project Structure

```
expense-tracker-api
├── README.md
├── AI_NOTES.md
├── src/
└── pom.xml
```

## Prerequisites

- Java 21
- Maven

## Install

```bash
mvn clean install
```

## Run

```bash
mvn spring-boot:run
```

or

```bash
./mvnw spring-boot:run
```

## Run Tests

```bash
mvn test
```

## Swagger

```
http://localhost:8080/swagger-ui/index.html
```

## API Endpoints

| Method | Endpoint |
|--------|----------|
| POST | `/api/expenses` |
| GET | `/api/expenses` |
| GET | `/api/expenses?category=Food` |
| GET | `/api/expenses/total` |
| GET | `/api/expenses/total?category=Food` |
| DELETE | `/api/expenses/{id}` |

## Sample Request

```json
{
  "title": "Lunch",
  "amount": 250,
  "category": "Food",
  "date": "2026-08-01"
}
```

## Notes

- In-memory storage (no database)
- IDs are generated automatically
- Validation and exception handling included
