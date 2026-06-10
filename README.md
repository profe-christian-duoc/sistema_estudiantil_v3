# Sistema de Microservicios Académicos - Duoc UC

Este repositorio contiene el ecosistema de microservicios independientes desarrollados con **Spring Boot 4.0.6** y **Java 25**, estructurados para gestionar la información del sistema estudiantil de manera aislada y desacoplada.

---

## 🚀 Arquitectura y Tecnologías

El sistema utiliza una arquitectura orientada a microservicios donde cada dominio cuenta con su propia persistencia y se comunica mediante clientes REST, respaldado por componentes de infraestructura distribuidos.

* **Java:** 25
* **Framework Principal:** Spring Boot 4.0.6 (Spring Boot Starter Web, Data JPA, Validation, OpenFeign)
* **Componentes Spring Cloud:** Netflix Eureka (Discovery Server), Spring Cloud Gateway (API Gateway), Spring Cloud Config (Config Server)
* **Base de Datos:** MySQL (un esquema independiente por servicio de negocio)
* **Evolución de Base de Datos:** Flyway Migration
* **Persistencia:** Hibernate / JPA
* **Productividad:** Lombok (con configuración explícita en el `maven-compiler-plugin`)

---

## 📦 Estructura del Proyecto

El repositorio está organizado en módulos independientes para cada componente de la arquitectura:

```text
├── config-server/           # Servidor de Configuración Centralizada (Puerto 8888)
├── eureka-server/           # Servidor de Descubrimiento de Servicios (Puerto 8761)
├── api-gateway/             # Puerta de Enlace y Enrutador del Sistema (Puerto 9090)
├── estudiantes-service/     # Gestión de Alumnos (Puerto 8091)
├── docentes-service/        # Gestión de Docentes (Puerto 8092)
├── asignaturas-service/     # Gestión de Asignaturas (Puerto 8093)
└── tutorias-service/        # Gestión de Tutorías - Orquestador Feign (Puerto 8094)
```
## 🛠️ Configuración y Requisitos Previos
### Base de Datos (MySQL)
Antes de levantar los servicios de negocio, asegúrate de tener una instancia de MySQL activa en el puerto por defecto (3306) y crea los siguientes esquemas vacíos. Las migraciones de Flyway se encargarán de crear las tablas y datos iniciales automáticamente al iniciar cada servicio:
```text
CREATE DATABASE IF NOT EXISTS bd_estudiantes;
CREATE DATABASE IF NOT EXISTS bd_docentes;
CREATE DATABASE IF NOT EXISTS bd_asignaturas;
CREATE DATABASE IF NOT EXISTS bd_tutorias;
```

