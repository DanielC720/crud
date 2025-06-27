CRUD de Productos - Spring Boot

Este proyecto es una API REST sencilla que permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre una lista de productos usando Spring Boot, H2 y JPA.

Tecnologías utilizadas

- Java 17+  
- Spring Boot  
- Spring Data JPA  
- H2 Database  
- Maven  
- Git

---

Como ejecutar 
Abre el proyecto en Spring Tool Suite, IntelliJ o VS Code con soporte de Spring Boot.

Asegúrate de tener Java 17 y Maven instalados.

Ejecuta la aplicación:

./mvnw spring-boot:run
También puedes ejecutarla desde tu IDE con el botón "Run" en la clase main InventarioApplication.

---
(http://localhost:8080/api/productos)

Endpoints disponibles
Crear un producto
POST /api/productos

Body (JSON):
{
  "nombre": "Camiseta",
  "categoria": "Ropa",
  "stock": 100,
  "precio": 199.99
}

Obtener todos los productos
GET /api/productos

Obtener un producto por ID
GET /api/productos/{id}

Actualizar un producto
PUT /api/productos/{id}

Body (JSON):
{
  "nombre": "Camiseta Actualizada",
  "categoria": "Ropa",
  "stock": 120,
  "precio": 249.99
}

Eliminar un producto
DELETE /api/productos/{id}

Consola de H2
Accede a la consola H2 desde el navegador:

http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
User: sa
Password: (déjalo en blanco)

