# FinCore Backend Setup

FinCore is a financial backend application built with **Java 21**, **Spring Boot 3**, and **PostgreSQL**. The application follows a clean **3-layer architecture** (Controller, Service, Repository) and uses **MapStruct** for DTO mapping along with **Flyway** for database migrations.

The application is fully containerized. Java 21 and the required runtime environment are included in the Docker container, so no Java installation is required when running the application through Docker.

For faster development and a shorter feedback loop, the backend can also be started directly on the host machine without Docker. In this case, Java 21 must be installed locally.

---

### 🛠️ Prerequisites

**For local development:**
* **Java Development Kit (JDK 21)**
* **IntelliJ IDEA** (or any IDE of your choice)
* **Docker & Docker Compose** for running PostgreSQL and other required services

**For running the application in Docker:**
* **Docker & Docker Compose**  
  *(Java 21 is already included in the application container)*

---

### ⚙️ Environment Variables (.env)

The project uses environment variables for sensitive data and container configuration.

Copy the example `.env.example` file and create a `.env` file in the root directory:

```bash
cp .env.example .env
