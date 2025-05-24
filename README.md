# ms-users

Microservicio de gestión de usuarios para sistemas distribuidos.

## Descripción

`ms-users` es un microservicio desarrollado en Java con Spring Boot, encargado de la administración de usuarios, autenticación y autorización. Forma parte de una arquitectura de microservicios y se comunica con otros servicios mediante REST y mensajería.

## Características

- Registro y gestión de usuarios
- Autenticación JWT
- Roles y permisos
- Integración con bases de datos relacionales
- API RESTful documentada con Swagger

## Tecnologías

- Java 17+
- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL/MySQL
- Docker
- Swagger/OpenAPI

## Instalación

1. Clona el repositorio:
    ```bash
    git clone https://github.com/tu-usuario/ms-users.git
    cd ms-users
    ```
2. Configura las variables de entorno en `application.properties` o usando variables de entorno.
3. Construye el proyecto:
    ```bash
    ./mvnw clean package
    ```
4. Ejecuta el servicio:
    ```bash
    java -jar target/ms-users-*.jar
    ```

## Uso

La API estará disponible en `http://localhost:8080/api/users`. Consulta la documentación Swagger en `http://localhost:8080/swagger-ui.html`.

## Endpoints principales

- `POST /api/users/register` — Registro de usuario
- `POST /api/users/login` — Autenticación
- `GET /api/users/{id}` — Obtener usuario por ID
- `PUT /api/users/{id}` — Actualizar usuario
- `DELETE /api/users/{id}` — Eliminar usuario

## Contribución

1. Haz un fork del repositorio.
2. Crea una rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -am 'Agrega nueva funcionalidad'`).
4. Haz push a la rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

## Licencia

Este proyecto está bajo la licencia MIT.

## Contacto

Para dudas o soporte, contacta a [tu-email@dominio.com].
