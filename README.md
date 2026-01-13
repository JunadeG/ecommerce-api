# Spring Boot E-Commerce API

A RESTful API for a simple e-commerce platform, built with Spring Boot. This project serves as a practical demonstration of modeling a complex `@ManyToMany` database relationship.

## Technologies Used

*   Java 17 (or your JDK version)
*   Spring Boot 3.x
*   Spring Data JPA / Hibernate
*   PostgreSQL
*   Maven
*   Lombok

## Features

*   Create and view products.
*   Create a customer order containing multiple products.
*   View all customer orders.
*   Built with a clean Controller-Service-Repository architecture with DTOs.
*   Demonstrates a `@ManyToMany` database relationship between Orders and Products, managed via a join table.

## Getting Started

To get a local copy up and running, follow these steps.

### Prerequisites

*   JDK 17 or higher
*   Maven 3.2+
*   A running instance of PostgreSQL

### Installation and Setup

1.  **Clone the repository**
    ```bash
    git clone https://github.com/JunadeG/ecommerce-api.git
    ```
2.  **Navigate to the project directory**
    ```bash
    cd ecommerce-api
    ```
3.  **Create the database**
    *   In your PostgreSQL client (e.g., pgAdmin), create a new, empty database named `ecommerce_db`.

4.  **Create the `application.properties` file**
    *   Navigate to the `src/main/resources/` directory.
    *   Create a new file named `application.properties`.
    *   Add the following content to the file, replacing `your_db_password` with your own PostgreSQL password.
    ```properties
    server.port=8091

    # Database Connection Properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce_db
    spring.datasource.username=postgres
    spring.datasource.password=your_db_password

    # Instruct Hibernate to automatically create/update tables
    spring.jpa.hibernate.ddl-auto=update
    ```

### Running the Application

*   Run the `ECommerceApiApplication.java` file from your IDE.

## API Endpoints

### Products

*   `GET /api/products` - Retrieves a list of all products.
*   `POST /api/products` - Creates a new product.
    *   **Body:**
        ```json
        {
          "name": "string",
          "description": "string",
          "price": 0.0
        }
        ```

### Orders

*   `GET /api/orders` - Retrieves a list of all orders.
*   `POST /api/orders` - Creates a new customer order.
    *   **Body (using the DTO):**
        ```json
        {
          "customerName": "string",
          "productIds": [1, 2, ...]
        }
        ```