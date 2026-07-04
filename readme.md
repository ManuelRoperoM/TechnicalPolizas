# Sistema de Gestión de Pólizas

API REST desarrollada como solución para una prueba técnica utilizando **Spring Boot 3.5**, **Java 17** y **MySQL**.

La aplicación permite administrar pólizas y sus riesgos asociados, incluyendo operaciones de creación, consulta, renovación y cancelación. Como parte de la solución, se implementó un servicio **Mock del CORE** para simular el envío de eventos, protegido mediante una API Key de acuerdo con el requerimiento de la prueba.

## Tecnologías

* Java 17
* Spring Boot 3.5
* Spring Web
* Spring Data JPA
* Spring Validation
* MySQL
* Lombok
* Swagger / OpenAPI
* Maven

## Arquitectura

El proyecto fue desarrollado siguiendo una arquitectura modular, separando cada dominio funcional en paquetes independientes.

```text
src/main/java
│
├── mock
│   ├── controller
│   ├── dto
│   ├── service
│
├── poliza
│   ├── controller
│   ├── dto
│   ├── entity
│   ├── mappers
│   ├── repository
│   ├── service
│   └── enums
│
├── riesgo
│   ├── controller
│   ├── dto
│   ├── entity
│   ├── enums
│   ├── repository
│   └── service
│
└── config
```

Cada módulo contiene su propia lógica de negocio, entidades, DTOs y repositorios, favoreciendo una mejor organización, mantenibilidad y escalabilidad del proyecto.

## Requisitos

* Java 17
* Maven 3.9+
* MySQL 8+

## Configuración

Configurar la conexión a la base de datos en el archivo:

```properties
src/main/resources/application.properties
```

Ejemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/polizas
spring.datasource.username=usuario
spring.datasource.password=contraseña

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Ejecución

Clonar el proyecto:

```bash
git clone <[URL_DEL_REPOSITORIO](git@github.com:ManuelRoperoM/TechnicalPolizas.git)>
```

Ingresar al directorio:

```bash
cd <technical-polizas>
```

Ejecutar la aplicación:

```bash
mvn spring-boot:run
```

La API quedará disponible en:

```text
http://localhost:8080
```

## Documentación

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

OpenAPI:

```text
http://localhost:8080/v3/api-docs
```

## Endpoints

### Pólizas

| Método | Endpoint                               | Descripción                                  |
| ------ | -------------------------------------- | -------------------------------------------- |
| POST   | `/polizas`                             | Registrar una póliza                         |
| GET    | `/polizas?tipo={tipo}&estado={estado}` | Consultar pólizas por tipo y estado          |
| POST   | `/polizas/{id}/riesgos`                | Crear y asociar un riesgo a una póliza       |
| GET    | `/polizas/{id}/riesgos`                | Consultar los riesgos asociados a una póliza |
| POST   | `/polizas/{id}/renovar`                | Renovar una póliza                           |
| POST   | `/polizas/{id}/cancelar`               | Cancelar una póliza y sus riesgos            |

### Riesgos

| Método | Endpoint                 | Descripción        |
| ------ | ------------------------ | ------------------ |
| POST   | `/riesgos/{id}/cancelar` | Cancelar un riesgo |

### Core Mock

| Método | Endpoint            | Descripción                           |
| ------ | ------------------- | ------------------------------------- |
| POST   | `/core-mock/evento` | Simular el envío de un evento al CORE |

Header requerido:

```text
x-api-key: 123456
```

Ejemplo de petición:

```json
{
    "evento": "ACTUALIZACION",
    "polizaId": 555
}
```

## Características implementadas

* Gestión completa de pólizas.
* Gestión de riesgos asociados a una póliza.
* Renovación automática de pólizas.
* Cancelación de pólizas y riesgos.
* Validación de solicitudes mediante Bean Validation.
* Persistencia con Spring Data JPA.
* Documentación automática mediante Swagger/OpenAPI.
* Mock del CORE para simular integración con un sistema externo.
* Validación básica mediante API Key para el servicio Mock.

## Autor
Manuel Alejandro Ropero Mosquera
Desarrollado como solución para una prueba técnica utilizando Spring Boot 3.5, Java 17 y MySQL.
