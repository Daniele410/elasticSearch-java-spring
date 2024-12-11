# **XML to Elasticsearch Indexer**

This project is a Java-based Spring Boot application designed to efficiently index product data into an Elasticsearch instance, either from JSON payloads or XML files. It includes the ability to upload and process XML files to index product data into Elasticsearch and provides endpoints for product management via a REST API.

---

## **Features**

- Index products into Elasticsearch from JSON and XML sources.
- Efficiently handle large XML files using streaming parsing (via SAXParser).
- Bulk indexing via Elasticsearch’s Bulk API to optimize large dataset handling.
- Delete or fetch products through RESTful API endpoints.
- Supports configuration of Elasticsearch host and port.
- Simple endpoints to upload XML files and manage indexed data.
- Detailed logging and error handling for debugging.

---

## **Technologies Used**

- **Java 21**: Programming language for implementation.
- **Spring Boot**: Framework for building the REST API.
- **Elasticsearch 8.8.2**: For indexing and searching product data.
- **SAXParser**: Efficient XML parser for streaming data.
- **Maven**: For project and dependency management.
- **Git**: For version control.

---

## **Setup Instructions**

### **1. Prerequisites**

Before running the application, ensure you have the following installed:

- **Java 21**: [Download Java](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html)
- **Maven**: [Install Maven](https://maven.apache.org/install.html)
- **Elasticsearch 8.8.2**: Follow the installation steps below.

---

### **2. Download and Install Elasticsearch 8.8.2**

1. Download Elasticsearch 8.8.2:
   - Go to the official **download page**:  
     [Download Elasticsearch 8.8.2](https://www.elastic.co/downloads/past-releases/elasticsearch-8-8-2)

2. Extract the downloaded archive:
   - **Linux/Mac**:
     ```bash
     tar -xzf elasticsearch-8.8.2-linux-x86_64.tar.gz
     cd elasticsearch-8.8.2
     ```
   - **Windows**:
     Extract the ZIP file into a folder of your choice.

3. Start Elasticsearch:
   - **Linux/Mac**:
     ```bash
     ./bin/elasticsearch
     ```
   - **Windows**:
     ```cmd
     bin\elasticsearch
     ```

4. Verify that Elasticsearch is running:
   - Navigate to [http://localhost:9200/](http://localhost:9200/) in your browser or execute:
     ```bash
     curl -X GET "http://localhost:9200/"
     ```

   You should see a JSON response with version and cluster information.

---

### **3. Clone and Build the Application**

1. Clone the repository:
    ```bash
    git clone <your-repository-url>
    cd <repository-folder>
    ```

2. Build the application using Maven:
    ```bash
    mvn clean install
    ```

3. Run the application:
    ```bash
    mvn spring-boot:run
    ```

---

### **4. Using the API Endpoints**

#### **Create a Product** (POST `/products`)

```bash
curl -X POST "http://localhost:8080/products" -H "Content-Type: application/json" -d '{
    "name": "Sample Product",
    "description": "Description of the sample product",
    "price": 199.99
}'