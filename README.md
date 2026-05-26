# Inventory Management API 

API REST robusta para la gestión y control de inventarios construida con **Spring Boot** y **Java 21**. Diseñada bajo buenas prácticas de arquitectura limpia, desacoplamiento de capas mediante DTOs y persistencia relacional.

## Tecnologías y Decisiones de Arquitectura

- **Java 21 & Spring Boot**: Uso de características modernas de la JVM.
- **Spring Data JPA & Hibernate**: Abstracción de datos y mapeo objeto-relacional eficiente.
- **MySQL 8.x**: Motor de base de datos relacional robusto.
- **Validación de Capas (Jakarta Validation)**: Restricciones explícitas a nivel DTO para evitar la corrupción de datos.

## Prácticas de Ingeniería Aplicadas

- **Abstracción mediante DTOs**: Aislamiento total de las entidades JPA del exterior, protegiendo el modelo de dominio.
- **Precisión Financiera**: Manejo de valores monetarios con `BigDecimal` para mitigar errores de redondeo binario.
- **Inyección de Dependencias por Constructor**: Acoplamiento débil y alta testabilidad de los componentes de servicio.

## Instalación y Despliegue

1. Clonar el repositorio:
   ```bash
   git clone [https://github.com/tu-usuario/inventory-management-api.git](https://github.com/tu-usuario/inventory-management-api.git)