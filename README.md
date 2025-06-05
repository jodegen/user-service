# 🧑‍💼 User Service (Auction Platform)

This service is responsible for managing user profiles, personal settings, and user-related metadata within the auction platform. It complements the `auth-service` by decoupling user authentication from profile management.

---

## 📦 Features

- Listen for events (e.g. `UserAccountCreatedEvent`) via Kafka
- Maintain user profile data (first name, last name, language, profile picture, etc.)
- Apply domain-driven principles via commands
- Expose profile information via REST API

---

## 🧱 Architecture

| Layer        | Description                                                                 |
|--------------|-----------------------------------------------------------------------------|
| `model`      | Contains core domain models such as `UserProfile`                           |
| `commands`   | Represents incoming commands that trigger domain-specific actions           |
| `listener`   | Consumes events (via Kafka) and maps them to commands                       |
| `service`    | Contains business logic and coordinates operations between components       |
| `rest`       | Exposes REST API endpoints for accessing user profile data                 |

> Note: The event and command DTOs are defined in a separate shared module: [`auction-platform-dtos`](https://github.com/jodegen/auction-platform-dtos)

---

## 🛠 Technologies

- Java 17+
- Spring Boot
- Apache Kafka
- Maven
- JPA/Hibernate
- PostgreSQL

---

## 📬 Events & Commands (Examples)

### Consumed Kafka Events
- `UserCreatedEvent`: Triggered by `auth-service` after user registration.

### Commands
- `CreateUserProfileCommand`

---

## 🚀 Getting Started

```bash
mvn clean install
docker-compose up -d
