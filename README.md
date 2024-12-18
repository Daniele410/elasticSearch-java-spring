
# Elasticsearch Spring Boot Application

## Overview
This application demonstrates how to integrate **Spring Boot** with **Elasticsearch**. It provides a REST API for managing products, including creating, reading, uploading via XML, and deleting records.

Elasticsearch is a distributed search and analytics engine that allows for storing, searching, and analyzing large volumes of data in near real-time.

---

## Technologies Used
- ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white) Java 17
- ![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white) Spring Boot 3.0
- ![Elasticsearch](https://img.shields.io/badge/Elasticsearch-005571?style=for-the-badge&logo=elasticsearch&logoColor=white) Elasticsearch 8.8.2
- ![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white) Docker
- ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white) Postman

---

## How to Run the Application Locally

### Prerequisites
1. Install [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html).
2. Install [Maven](https://maven.apache.org/download.cgi).
3. Install [Docker](https://www.docker.com/products/docker-desktop/).

### Steps
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd <repository-folder>
   ```
2. Start Elasticsearch using Docker:
   ```bash
   docker run -d --name elastic-test -p 9200:9200 -e "discovery.type=single-node" -e "xpack.security.enabled=false" docker.elastic.co/elasticsearch/elasticsearch:8.8.2
   ```
3. Build and run the Spring Boot application:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
4. Access the application at `http://localhost:8080`.

---

## Running the Application with Docker Compose

1. Build the application and create a Docker image:
   ```bash
   mvn clean install -DskipTests
   ```

2. Start the application using Docker Compose:
   ```bash
   docker-compose up -d
   ```

3. Access the application at `http://localhost:8080`, and Elasticsearch at `http://localhost:9200`.


4. For stop the application:
   ```bash
   docker-compose down
   ```

**Note:** Ensure the `docker-compose.yml` file is present in the project root.

---

## Postman Collection
The Postman collection for testing the API is located at:  
`src/main/resources/postman/ElasticsearchSpring.postman_collection.json`

---

## API Endpoints

### 1. Create a Product
- **Method:** `POST`
- **URL:** `/products`
- **Description:** Creates a new product.
- **cURL:**
  ```bash
  curl -X POST http://localhost:8080/products -H "Content-Type: application/json" -d '{
    "id": "1",
    "name": "Product 1",
    "description": "Description for Product 1",
    "price": 100.0
  }'
  ```

### 2. Get All Products
- **Method:** `GET`
- **URL:** `/products`
- **Description:** Retrieves all products.
- **cURL:**
  ```bash
  curl -X GET http://localhost:8080/products
  ```

### 3. Upload Products via XML
- **Method:** `POST`
- **URL:** `/products/upload-file`
- **Description:** Uploads products from an XML file.
- **cURL:** Example using Postman for uploading files.

### 4. Delete a Product
- **Method:** `DELETE`
- **URL:** `/products/{id}`
- **Description:** Deletes a specific product by its ID.
- **cURL:**
  ```bash
  curl -X DELETE http://localhost:8080/products/1
  ```

### 5. Delete All Products
- **Method:** `DELETE`
- **URL:** `/products`
- **Description:** Deletes all products.
- **cURL:**
  ```bash
  curl -X DELETE http://localhost:8080/products
  ```

## Notes
- Make sure Elasticsearch is running before starting the Spring Boot application.
- Test the endpoints using Postman or `curl` commands provided above.

Happy coding! 🚀
