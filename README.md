# FinCore Analytics - Backend Setup

FinCore is a financial analysis application built with Java 21, Spring Boot 3, and PostgreSQL, following the principles of **Hexagonal Architecture (Ports & Adapters)**.

The application is fully containerized. **Java 21 and the required runtime environment are included in the Docker container**, so no Java installation is required when running the application through Docker.

For faster development and a shorter feedback loop, the backend can also be started **directly on the host machine without Docker**. In this case, Java 21 must be installed locally.

---

## 🛠️ Prerequisites

### For local development

* **Java Development Kit (JDK 21)**
* **IntelliJ IDEA** (or any IDE of your choice)
* **Docker & Docker Compose** for running PostgreSQL and other required services

### For running the application in Docker

* **Docker & Docker Compose**

> Java 21 is already included in the application container.

---

## ⚙️ Environment Variables (.env)

The project uses environment variables for sensitive data and container configuration.

1. Copy the example `.env.example` file and create a `.env` file in the root directory:

   ```bash
   cp .env.example .env
   ```

2. Configure the required environment variables in the `.env` file.

---

## 🚀 Development

For faster development, the backend can be started directly from IntelliJ IDEA or the command line using the locally installed JDK 21.

Docker can still be used to provide the required infrastructure, such as PostgreSQL.

This setup allows you to develop and restart the Spring Boot application quickly without rebuilding the application Docker image after every code change.

For production-like execution, the complete application can be built and run inside Docker.
