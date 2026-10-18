<div align="center">

# 🧑‍💼 Person–Aadhaar–Book Spring Boot REST API

![Java](https://img.shields.io/badge/Java-17-blue?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-Hibernate-green?logo=hibernate&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue?logo=postgresql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build%20Tool-orange?logo=apachemaven&logoColor=white)
![REST API](https://img.shields.io/badge/REST-API-red)

A Spring Boot application that demonstrates **JPA entity relationships** using **One-to-One** and **One-to-Many** mappings through a simple REST API.  
It manages **Persons**, their **Aadhaar details**, and the **Books** they own.

</div>

---

## 📑 Table of Contents

- [✨ Features](#-features)
- [🛠️ Tech Stack](#️-tech-stack)
- [📂 Project Structure](#-project-structure)
- [🔗 Entities & Relationships](#-entities--relationships)
- [⚙️ Setup & Installation](#️-setup--installation)
- [🗄️ Database Configuration](#️-database-configuration)
- [🚀 Run the Application](#-run-the-application)
- [🌐 API Endpoints](#-api-endpoints)
- [🧪 Sample Usage](#-sample-usage)
- [⚠️ Known Limitations](#️-known-limitations)
- [👨‍💻 Author](#-author)

---

## ✨ Features

- 🧑 Manage **Person** records
- 🪪 Store and manage **Aadhaar** details
- 📚 Add and manage **Books**
- 🔗 Demonstrates **One-to-One** relationship: `Person → Aadhaar`
- 📚 Demonstrates **One-to-Many** relationship: `Person → Books`
- 🌐 Fully functional **REST API**
- 🗄️ PostgreSQL database integration
- 🍃 Spring Data JPA with Hibernate
- 🔍 Search APIs by name, phone number, gender, age, title, author, price, and more
- ♻️ CRUD operations for all entities

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| ☕ Java 17+ | Programming language |
| 🌱 Spring Boot 3.x | Application framework |
| 🌐 Spring Web | REST API development |
| 🍃 Spring Data JPA | Database persistence |
| 🦔 Hibernate | ORM implementation |
| 🐘 PostgreSQL | Relational database |
| 📦 Maven | Dependency and build management |

---

## 📂 Project Structure

```text
PersonAadhaarSpringboot/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/
    │   │       └── first/
    │   │           ├── PersonAadhaarSpringbootApplication.java
    │   │           │
    │   │           ├── Aadhaar.java
    │   │           ├── AadhaarRepo.java
    │   │           ├── AadhaarController.java
    │   │           │
    │   │           ├── Book.java
    │   │           ├── BookRepo.java
    │   │           ├── BookController.java
    │   │           │
    │   │           ├── Person.java
    │   │           ├── PersonRepo.java
    │   │           └── PersonController.java
    │   │
    │   └── resources/
    │       └── application.properties
    │
    └── test/
        └── java/
            └── com/
                └── first/
                    └── PersonAadhaarSpringbootApplicationTests.java
````

---

## 🔗 Entities & Relationships

### 🧑 Person

| Field | Description |
|---|---|
| `pid` | Primary key |
| `name` | Person’s name |
| `age` | Person’s age |
| `gender` | Person’s gender |
| `phonoNo` | Phone number |
| `aadhaar` | Linked Aadhaar details |
| `books` | List of books owned by the person |

### 🪪 Aadhaar

| Field | Description |
|---|---|
| `aid` | Primary key |
| `anum` | Aadhaar number |
| `address` | Address |

### 📚 Book

| Field | Description |
|---|---|
| `bid` | Primary key |
| `title` | Book title |
| `author` | Book author |
| `price` | Book price |

### 🔗 Relationship Mapping

| Relationship | Type | Description |
|---|---|---|
| `Person → Aadhaar` | One-to-One | Each person has one Aadhaar record |
| `Person → Book` | One-to-Many | One person can own multiple books |

---

## ⚙️ Setup & Installation

### 1️⃣ Clone the Repository

```bash
git clone [https://github.com/your-username/PersonAadhaarSpringboot.git](https://github.com/your-username/PersonAadhaarSpringboot.git)
cd PersonAadhaarSpringboot
```

### 2️⃣ Open in IDE

Open the project in:

- IntelliJ IDEA
- Eclipse
- Spring Tool Suite (STS)
- VS Code

### 3️⃣ Required Dependencies

Make sure your `pom.xml` includes:

- `spring-boot-starter-web`
- `spring-boot-starter-data-jpa`
- `org.postgresql:postgresql`

---

## 🗄️ Database Configuration

Create a PostgreSQL database:

```sql
CREATE DATABASE person_aadhaar_db;
```

Update `src/main/resources/application.properties`:

```properties
spring.application.name=PersonAadhaarSpringboot

# PostgreSQL Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/person_aadhaar_db
spring.datasource.username=postgres
spring.datasource.password=your_password

# JPA / Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

### 🔁 Replace These Values

| Placeholder | Replace With | Example |
|---|---|---|
| `port Number` | PostgreSQL port | `5432` |
| `database-name` | Your database name | `person_aadhaar_db` |
| `Database` | PostgreSQL username | `postgres` |
| `password` | PostgreSQL password | `your_password` |

> ⚠️ **Security Note:** Do not commit real database passwords to GitHub. Use environment variables or a local-only configuration file.

---

## 🚀 Run the Application

Run the project using Maven:

```bash
mvn spring-boot:run
```

The application will start at:

```text
http://localhost:8080
```

---

## 🌐 API Endpoints

### 🪪 Aadhaar APIs

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/aadhaar/save` | Save an Aadhaar record |
| `GET` | `/aadhaar/{aid}` | Get Aadhaar by ID |
| `GET` | `/aadhaar/all` | Get all Aadhaar records |
| `PUT` | `/aadhaar/update` | Update an Aadhaar record |
| `DELETE` | `/aadhaar/delete/{aid}` | Delete Aadhaar by ID |
| `GET` | `/aadhaar/anum/{anum}` | Find Aadhaar by Aadhaar number |
| `GET` | `/aadhaar/address/{address}` | Find Aadhaar by address |

### 📚 Book APIs

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/book/save` | Save a book |
| `GET` | `/book/{bid}` | Get book by ID |
| `GET` | `/book/all` | Get all books |
| `PUT` | `/book/update` | Update a book |
| `DELETE` | `/book/delete/{bid}` | Delete book by ID |
| `GET` | `/book/title/{title}` | Find books by title |
| `GET` | `/book/price/{price}` | Find books by price |
| `GET` | `/book/author/{author}` | Find books by author |

### 🧑 Person APIs

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/person/save/{aid}` | Save a person linked to an Aadhaar |
| `POST` | `/person/{pid}/book/{bid}` | Add a book to a person |
| `PUT` | `/person/update` | Update a person |
| `DELETE` | `/person/delete/{pid}` | Delete person by ID |
| `GET` | `/person/{pid}` | Get person by ID |
| `GET` | `/person/all` | Get all persons |
| `GET` | `/person/phono/{phonoNo}` | Find person by phone number |
| `GET` | `/person/name/{name}` | Find person by name |
| `GET` | `/person/age/{age}` | Find person by age |
| `GET` | `/person/gender/{gender}` | Find person by gender |
| `GET` | `/person/name/{name}/gender/{gender}` | Find person by name and gender |
| `GET` | `/findByPidAndName/{pid}/{name}` | Find person by ID and name |
| `GET` | `/person/{pid}/book/{bid}` | Find person by ID and owned book ID |

---

## 🧪 Sample Usage

### 1️⃣ Create an Aadhaar

```http
POST /aadhaar/save
Content-Type: application/json
```

```json
{
  "anum": 123456789012,
  "address": "Palghar, Maharashtra"
}
```

### 2️⃣ Create a Book

```http
POST /book/save
Content-Type: application/json
```

```json
{
  "title": "Effective Java",
  "author": "Joshua Bloch",
  "price": 599.0
}
```

### 3️⃣ Create a Person Linked to Aadhaar

```http
POST /person/save/1
Content-Type: application/json
```

```json
{
  "name": "Rahul",
  "age": 25,
  "gender": "Male",
  "phonoNo": 9876543210
}
```

### 4️⃣ Add a Book to the Person

```http
POST /person/10/book/10
```

> 💡 **Recommended order:** Create the Aadhaar and Book first, then create the Person, and finally link the Book to the Person.

---

## ⚠️ Known Limitations

- `findById(...).get()` can throw `NoSuchElementException` if the ID does not exist.  
  ✅ Consider returning a proper `404 Not Found` response using custom exceptions.

- `findByGender()` returns `Optional<Person>`, which fails when multiple persons have the same gender.  
  ✅ Use `List<Person>` instead.

- `findByPhonoNo()` assumes phone numbers are unique.  
  ✅ Add a unique constraint if phone numbers must be unique.

- Entities are exposed directly in API responses.  
  ✅ Use DTOs and validation annotations such as `@Valid`, `@NotNull`, and `@Size`.

- Aadhaar details are sensitive personal information.  
  ✅ Add Spring Security before using this project in a real-world application.

- Field injection with `@Autowired` is used.  
  ✅ Prefer constructor-based dependency injection.

---

## 🚀 Future Improvements

- 🔐 Add Spring Security and JWT authentication
- 🧾 Add DTOs and request validation
- 🚨 Add global exception handling using `@RestControllerAdvice`
- 📄 Add Swagger / OpenAPI documentation
- 🧪 Add unit and integration tests
- 🐳 Add Docker support
- ☁️ Deploy using Render, Railway, or AWS

---

## 👨‍💻 Author

<div align="center">

**Harsh Gharat**

[![GitHub](https://img.shields.io/badge/GitHub-your--username-black?logo=github)](https://github.com/gharatharsh)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Your%20Name-blue?logo=linkedin)](www.linkedin.com/in/harsh-gharat)

</div>

---

<div align="center">

### ⭐ If you found this project helpful, consider giving it a star!

</div>
