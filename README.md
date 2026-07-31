# Smart Expense Tracker API

A RESTful API built using Java and Spring Boot for managing personal expenses.

This project was developed as part of the **Diligent Software Engineering Apprenticeship 2026 Assignment**.

---

## Features

- Add a new expense
- View all expenses
- Filter expenses by category
- Calculate total expenses
- Calculate category-wise total expenses
- Delete an expense
- Input validation
- Global exception handling
- Swagger/OpenAPI documentation

---

## Technology Stack

- Java 21
- Spring Boot
- Maven
- Lombok
- JUnit 5
- Swagger (springdoc-openapi)

---

## Project Structure

```
expense-tracker-api
│
├── README.md
├── AI_NOTES.md
├── src
│   ├── main
│   └── test
└── pom.xml
```

---

## Prerequisites

- Java 21
- Maven 3.9+
- Git

---

## Install Dependencies

```bash
mvn clean install
```

---

## Run the Application

```bash
mvn spring-boot:run
```

Alternative:

```bash
./mvnw spring-boot:run
```

---

## Run Tests

```bash
mvn test
```

---

## Swagger Documentation

After starting the application, open:

```
http://localhost:8080/swagger-ui/index.html
```

---

# API Endpoints

| Method | Endpoint | Description |
|----------|----------------------------|------------------------------|
| POST | /api/expenses | Add a new expense |
| GET | /api/expenses | Get all expenses |
| GET | /api/expenses?category=Food | Filter by category |
| GET | /api/expenses/total | Get total expenses |
| GET | /api/expenses/total?category=Food | Get category-wise total |
| DELETE | /api/expenses/{id} | Delete an expense |

---

# Sample Request

## Add Expense

**POST**

```
/api/expenses
```

Request Body

```json
{
  "title": "Lunch",
  "amount": 250,
  "category": "Food",
  "date": "2026-08-01"
}
```

Response

```json
{
  "id": 1,
  "title": "Lunch",
  "amount": 250.0,
  "category": "Food",
  "date": "2026-08-01"
}
```

---

## Get All Expenses

```
GET /api/expenses
```

---

## Filter by Category

```
GET /api/expenses?category=Food
```

---

## Get Total Expenses

```
GET /api/expenses/total
```

---

## Delete Expense

```
DELETE /api/expenses/1
```

---

## Validation

The application validates:

- Title must not be blank
- Category must not be blank
- Amount must be greater than zero
- Date is required

Validation errors return **HTTP 400 Bad Request**.

---

## Error Handling

Invalid delete requests return:

**404 Not Found**

Example:

```json
{
  "message": "Expense not found with id: 100"
}
```

---

## Notes

- Expenses are stored in memory.
- No database is required.
- IDs are generated automatically by the application.
- This implementation follows the assignment requirement of avoiding database persistence.