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

## 🚀 Ejecución en Entorno Híbrido

El sistema está diseñado para funcionar de forma flexible en dos modalidades: **Local (Nativo)** o **Contenerizado (Docker)**, adaptándose a las necesidades de tu entorno de desarrollo.

---

### 1. Modalidad Local (Sin Docker)
Ideal si deseas ejecutar los microservicios desde tu IDE (IntelliJ, Eclipse, etc.) o consola, utilizando herramientas locales.

* **Requisitos:** Tener activo tu servidor MySQL local (por ejemplo, mediante **XAMPP** o Workbench) y el servidor de Discovery (**Eureka**) ejecutándose en tu máquina.
* **Base de Datos:** Debes crear de forma manual la base de datos `bd_asignaturas` (y las correspondientes a cada servicio) antes de iniciar las aplicaciones.
* **Variables de Entorno:** El sistema detectará automáticamente la ausencia de contenedores y utilizará los valores por defecto apuntando a `localhost`.

### 2. Modalidad Contenerizada (Con Docker)
Ideal para desplegar toda la arquitectura de microservicios e infraestructura con un solo comando, garantizando que todo funcione en un entorno aislado y controlado.

* **Requisitos:** Tener instalado y en ejecución **Docker Desktop**.
* **Despliegue:** No necesitas crear las bases de datos ni configurar conexiones manualmente; Docker Compose se encarga de todo el ciclo de vida (redes, volúmenes, inicialización de bases de datos y aprovisionamiento del Config Server).

Para construir las imágenes, compilar el código fuente Java y levantar todos los servicios en segundo plano, ejecuta desde la raíz del proyecto:

```bash
docker compose up --build -d
