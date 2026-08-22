# API REST - Gestión de Atenciones Médicas

API REST desarrollada con Spring Boot para la gestión de pacientes, empleados, médicos, especialidades y atenciones médicas.

El proyecto implementa autenticación y autorización mediante JWT, persistencia de datos con Spring Data JPA y conexión a una base de datos PostgreSQL.

##  Tecnologías utilizadas
- Java 21
- 🌱 Spring Boot 4.0.6
- 🔐 Spring Security
- 🎫 JWT - JSON Web Token
- 🗄️ PostgreSQL
- 🧩 Spring Data JPA / Hibernate
- ✅ Spring Validation
- 📦 Maven


## Características

Autenticación de usuarios mediante JWT
- 👤 Gestión de usuarios
- 👨‍⚕️ Gestión de empleados
- 🧑‍🤝‍🧑 Gestión de pacientes
- 🩺 Gestión de especialidades
- 🔗 Relación entre médicos(empleado) y especialidades
- 📅 Gestión de atenciones médicas
- 🔎 Consultas de atenciones por fecha
- 👨‍⚕️ Consultas de atenciones por médico
- 👤 Consulta de las atenciones asociadas al usuario autenticado
- ✅ Validación de datos mediante Bean Validation
- 🔒 Protección de endpoints mediante Spring Security

## DB - PostgreSQL

```bash
1. Crear una base de datos PostgreSQL.
2. Ejecutar `database.sql`.
```

##  Instalación y ejecución

Clonar el repositorio

```bash
git clone https://github.com/JohanPOO/api-spring-boot-jwt.git
```
Configurar las variables de entorno

```bash
DB_URL=jdbc:postgresql://localhost:5432/nombre_base_datos
DB_USERNAME=postgres
DB_PASSWORD=tu_password
JWT_SECRET=tu_clave_secreta
```
Ejecutar la aplicación

```bash
mvnw.cmd spring-boot:run
```

#### 🏥 Atenciones


| Método | Endpoint | Descripción |
| :--- | :--- | :--- |
| `GET` | `/api/atenciones` | Muestra la lista de todas las atenciones. |
| `GET` | `/api/atenciones/mias` | Obtener las atenciones del que esta autenticado |
| `GET` | `/api/atenciones/fecha/{fecha}` | Buscar atenciones por fecha |
| `GET` | `	/api/atenciones/medico/{medico}` | Buscar atenciones por médico |
| `GET` | `/api/atenciones/{id}` | Obtener una atención |
| `POST` | `/api/atenciones` | Registrar una atención |
| `PUT` | `/api/atenciones/{id}` | Actualizar una atención |
| `DELETE` | `/api/atenciones/{id}` | Eliminar una atención |

### Ejemplo
```bash
GET http://localhost:8080/api/atenciones
Authorization: Bearer <JWT>
```

---

#### 👤 Otros recursos
La API también cuenta con controladores para:

- Usuarios
- Pacientes
- Personas
- Empleados
- Especialidades
- Médico-especialidad
- Atenciones

## Licencia

Este es un proyecto de estudio y está bajo la licencia [MIT](https://choosealicense.com/licenses/mit/)
