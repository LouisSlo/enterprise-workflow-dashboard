# Enterprise Task & Workflow Tracking API

## Overview
A robust backend REST API designed for enterprise workflow management and task status tracking. Built with **Java** and **Spring Boot**, this project demonstrates scalable software architecture, effective data modeling, and comprehensive API documentation.

This project was developed with a strong focus on clean code, automated testing, and proper exception handling, simulating a real-world enterprise environment.

## Technologies Used
* **Java 21**
* **Spring Boot 3** (Web, Data JPA)
* **H2 Database** (In-memory SQL database for rapid development and testing)
* **JUnit 5 & Mockito** (Unit Testing)
* **Swagger / OpenAPI 3** (Automated Technical Documentation)
* **Maven** (Dependency Management)

## Key Features
* **Task Lifecycle Management:** Create, retrieve, and update tasks across various workflow states (OPEN, IN_PROGRESS, IN_TESTING, DONE).
* **Global Error Handling:** Implemented `@RestControllerAdvice` to ensure clean, consistent HTTP responses (e.g., proper 404 handling).
* **Automated Documentation:** Fully integrated Swagger UI for seamless frontend/backend collaboration.
* **Tested Solutions:** High code coverage for business logic ensuring system reliability.

## How to Run Locally
1. Clone the repository: `git clone https://github.com/yourusername/enterprise-task-workflow-api.git`
2. Navigate to the project directory.
3. Run the application using Maven:
   ```bash
   ./mvnw spring-boot:run
