# Springboot Kafka Learning

A hands-on learning project for building event-driven microservices with Spring Boot and Apache Kafka.

This repository demonstrates how to connect multiple services using Kafka as the messaging backbone, while also integrating PostgreSQL for persistent order data and Docker for local infrastructure setup.

## Project Overview

The project contains two Spring Boot microservices:

- Kafka_order_service
  - Handles order creation and persistence
  - Produces Kafka events when an order is created
  - Uses PostgreSQL and Flyway for database migrations

- Kafka_notification_service
  - Consumes Kafka events
  - Simulates notification processing for newly created orders

## Architecture

Order Service -> Kafka Topic -> Notification Service

This pattern shows a simple event-driven design where one service publishes an event and another service reacts to it asynchronously.

## Tech Stack

- Java 21
- Spring Boot 3 / 4
- Apache Kafka
- PostgreSQL
- Flyway
- Docker / Docker Compose
- Maven

## Repository Structure

```bash
Springboot-kafka-learning/
├── Kafka_order_service/
│   ├── src/
│   ├── pom.xml
│   ├── docker-compose.yml
│   └── dockerFile
├── Kafka_notification_service/
│   ├── src/
│   ├── pom.xml
│   └── ...
└── README.md
```

## Prerequisites

Before running the project, make sure you have:

- Java 21+
- Maven
- Docker and Docker Compose
- A local environment that can run PostgreSQL and Kafka

## Run the Project

### 1. Start Kafka infrastructure

From the order service directory:

```bash
cd Kafka_order_service
docker compose up -d
```

### 2. Run the Order Service

```bash
cd Kafka_order_service
./mvnw spring-boot:run
```

### 3. Run the Notification Service

```bash
cd Kafka_notification_service
./mvnw spring-boot:run
```

Once both services are running, the order service can publish events to Kafka and the notification service can consume them.

## Features

- Event-driven communication using Kafka
- Order creation flow with persistence in PostgreSQL
- Flyway-based database migration
- Local Kafka UI support via Docker
- Spring Boot-based service development

## About Us

We are a learning-focused team exploring real-world backend patterns, event-driven systems, and microservice architecture with Spring Boot and Kafka.

## License

This project is intended for learning and experimentation.
