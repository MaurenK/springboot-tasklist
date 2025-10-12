## 📝 Tasklist API

A simple Spring Boot REST API for managing tasks with due dates and completion status.
Built with Spring Boot, PostgreSQL, and Docker.

## 🚀 Features

Add new tasks with due dates

List all tasks (with status filter)

Mark tasks as completed

Connects to PostgreSQL database

Containerized with Docker & Docker Compose

## 🛠️ Tech Stack

Java 17+

Spring Boot

PostgreSQL

Docker & Docker Compose

Maven

## 📂 Project Setup
# 1️⃣ Clone the repository
git clone https://github.com/<your-username>/<your-repo>.git
cd <your-repo>

# 2️⃣ Build the project
./mvnw clean package -DskipTests

# 3️⃣ Run with Docker
docker-compose up --build


This will start:

springboot_app → your API

postgres_db → PostgreSQL database

## 🔑 API Endpoints

Base URL: http://localhost:8080/api/tasks

Method	Endpoint	Description
POST	/	Create a new task
GET	/	List all tasks
GET	/?status=completed	List completed tasks
PUT	/{id}/complete	Mark a task completed
🗄️ Database (Postgres)

Default credentials (from docker-compose.yml):

DB Name: taskdb

User: postgres

Password: postgres

Port: 5432

## 🖥️ Testing

You can test the API using Postman or curl:

curl -X POST http://localhost:8080/api/tasks \
  -H "Content-Type: application/json" \
  -d '{"title":"Learn Docker","dueDate":"2025-10-10"}'

## 📌 Future Improvements

Add authentication (JWT)

Deploy to Kubernetes

Add frontend (React Admin Dashboard)
