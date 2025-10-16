# SpringFromScratch
A RESTful e-commerce shopping cart API built with Spring Boot and MySQL. This portfolio project demonstrates backend development fundamentals including JPA/Hibernate, service layer architecture, and RESTful API design.

# Features
- Product catalog with search and filtering (by name, brand, category)
- Category management with duplicate prevention
- Shopping cart CRUD operations (add, update, remove items)
- Product image upload and storage
- Automatic price calculations and inventory tracking
- Clean API responses with custom exception handling

# Tech Stack
- Spring Boot 3.x
- MySQL 8.0
- Spring Data JPA / Hibernate
- ModelMapper
- Lombok

# Quick Start

Clone and navigate to project

git clone https://github.com/SNatty98/SpringFromScratch.git

cd SpringFromScratch

Set up MySQL database

CREATE DATABASE shopping_cart_db;

# Configure application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/shopping_cart_db?useSSL=false&serverTimezone=UTC

spring.datasource.username=root

spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update

server.port=9193

api.prefix=/api/v1

Run the application

mvn spring-boot:run

API runs at http://localhost:9193

# Postman Testing

To be continuously updated until the project is complete:

[Postman](https://web.postman.co/workspace/My-Workspace~6ab18c9c-00d7-4254-8302-a91143db6b85/collection/18955773-e7964239-facc-4961-a1bf-dc6a7bd55810?action=share&source=copy-link&creator=18955773)

# Key Highlights

- Smart cart logic - Automatically merges duplicate products and recalculates totals
- DTO pattern - Clean separation between entities and API responses
- Robust error handling - Custom exceptions with meaningful HTTP status codes
- BigDecimal precision - Accurate financial calculations
- Image handling - BLOB storage with unique download URLs

# Roadmap
Future enhancements planned:

- User authentication
- Order processing
- Deploy using Docker
- Showcase Postman collections

Built as a portfolio project to demonstrate Spring Boot and RESTful API development