# Spring-CRUD-MongoDB

This project is a Spring Boot application that demonstrates a simple CRUD operation for managing products in MongoDB using MapStruct for object mapping and DTOs (Data Transfer Objects) for communication between layers.

## Project Structure

The project follows a clean architecture pattern with the following packages:

1. **controllers** - Handles HTTP requests and exposes REST API endpoints for marque operations.
2. **dto** - Contains DTOs (Data Transfer Objects) for transferring data between the service and controller layers.
3. **entities** - Contains the domain entities that represent the MongoDB collections.
4. **exceptions** - Centralized exception handling for the application.
5. **mappers** - Contains MapStruct mappers for converting between entities and DTOs.
6. **repositories** - Contains interfaces for interacting with MongoDB using Spring Data MongoDB.
7. **services** - Contains business logic for handling marque operations.

## Getting Started

### Requirements

- Java 17 or higher
- MongoDB
- Maven

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/Spring-CRUD-MongoDB.git

# Implementation

## MapStruct Integration

MapStruct is used in this project to automatically generate the mapping code between the `Product` entity and the `ProductDto`. This eliminates the need for writing boilerplate code to convert between the entity and DTO.

### Step 1: Add MapStruct Dependency

In the `pom.xml`, we include the MapStruct dependency:

  ```xml 
  <dependency>
    <groupId>org.mapstruct</groupId>
    <artifactId>mapstruct</artifactId>
    <version>${mapstruct.version}</version>
  </dependency>
  ```
We also configure the MapStruct processor as an annotation processor in the Maven build configuration:
````xml
 <plugin>
   <groupId>org.apache.maven.plugins</groupId>
   <artifactId>maven-compiler-plugin</artifactId>
   <version>${maven-compiler-plugin.version}</version>
   <configuration>
      <annotationProcessorPaths>
         <path>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>${lombok.version}</version>
         </path>
         <path>
            <groupId>org.mapstruct</groupId>
            <artifactId>mapstruct-processor</artifactId>
            <version>${mapstruct.version}</version>
         </path>
      </annotationProcessorPaths>
   </configuration>
</plugin>
````

### Step 2: Create the Mapper Interface
We create the ProductMapper interface to handle the mapping between `Product` and `ProductDto`. This interface is 
annotated with `@Mapper`, and MapStruct generates the implementation at compile time.

```java
@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product mapToEntity(ProductDto marqueDto);

    ProductDto mapToDto(Product marque);
}
```

### Step 3: Using the Mapper in Service Layer
In the `IProductServiceImp` service class, we use the ``ProductMapper`` to convert between entities and DTOs. 
This ensures the business logic layer deals with DTOs instead of the entities directly.

For example:
```java
@Override
public ProductDto add(ProductDto marqueDto) {
    Product marque = productMapper.mapToEntity(marqueDto);
    marque.setCreatedAt(LocalDateTime.now());
    return productMapper.mapToDto(productRepository.save(marque));
}
```

## DTOs
DTOs (Data Transfer Objects) are used to transfer data between the layers of the application. In this project, the ``ProductDto`` is a record introduced in Java 14 to represent the marque data.
The ``ProductDto`` encapsulates the marque information, such as ``id``, ``name``, and ``quantity``.

```java
public record ProductDto(String id, String name, int quantity) {
   // No additional methods are needed as the record automatically provides
   // getters, equals, hashCode, and toString methods.
}
```

### Exception Handling

The ``ExceptionHandlerAdvice`` class provides centralized exception handling. For example, if a ``Product`` is not found, an ``IllegalArgumentException`` is thrown, and the exception is caught and handled to return an appropriate error message.

````java
@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
@ExceptionHandler(IllegalArgumentException.class)
public Map<String, String> handleIException(IllegalArgumentException exception) {
    Map<String, String> map = new HashMap<>();
    map.put("error", exception.getMessage());
    return map;
}
````