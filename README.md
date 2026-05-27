# Inventory Management API

Una API REST profesional desarrollada con **Java 21** y **Spring Boot 4** para la gestión eficiente de inventarios de productos. Este proyecto fue diseñado aplicando buenas prácticas de desarrollo de software, separación de responsabilidades y manejo controlado de errores corporativos.

---

## Tecnologías Utilizadas

* **Lenguaje:** Java 21 (LTS)
* **Framework:** Spring Boot 4.0.6
* **Base de Datos:** MySQL (Persistencia en entorno de producción)
* **Documentación:** Springdoc OpenAPI / Swagger UI
* **Gestor de Dependencias:** Maven
* **Herramientas de Productividad:** Lombok & Jakarta Validation

---

## Arquitectura y Buenas Prácticas Aplicadas

Para garantizar que el sistema sea mantenible y escalable, implementé los siguientes patrones arquitectónicos:

1. **Patrón DTO (Data Transfer Object):** Desacoplamiento total entre las entidades de la base de datos (`Product`) y las solicitudes del cliente (`ProductRequestDTO`), protegiendo la integridad de los datos.
2. **Arquitectura en Capas:** Separación limpia de responsabilidades:
   * **Controlador (Controller):** Expone las rutas HTTP de la API REST.
   * **Servicio (Service):** Contiene el 100% de la lógica de negocio.
   * **Repositorio (Repository):** Abstracción de las consultas a la base de datos mediante Spring Data JPA.
3. **Escudo Global de Excepciones:** Implementación de un `@RestControllerAdvice` para interceptar errores en tiempo de ejecución. Mapea de forma limpia las validaciones fallidas (`400 Bad Request`) y recursos no encontrados (`404 Not Found`) en una estructura JSON estandarizada (`ErrorResponseDTO`).

---

## Documentación Interactiva (Swagger UI)

La API cuenta con documentación automatizada e interactiva bajo el estándar **OpenAPI**. Puedes visualizar, explorar y probar todos los endpoints del sistema directamente desde el navegador web sin necesidad de clientes externos como Postman.

* **Ruta de acceso en desarrollo:** `http://localhost:8080/swagger-ui.html`

---

## Cómo Ejecutar el Proyecto Localmente

### Requisitos Previos:
* Java 21 JDK instalado.
* Maven instalado.
* Servidor MySQL activo.

### Pasos:
1. Clonar el repositorio:
   ```bash
   git clone [https://github.com/saulsotodev/inventory-management-api.git](https://github.com/saulsotodev/inventory-management-api.git)