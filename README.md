# Sistema de gestion meteorologica

API REST construida con Spring Boot, Spring Data JPA y PostgreSQL para gestionar ciudades, estaciones, mediciones, tipos de medicion, usuarios, roles y alertas.

## Requisitos

- Java 21 o superior.
- PostgreSQL ejecutandose en el puerto `5432`.
- Base de datos llamada `clima`.
- Maven Wrapper incluido en el proyecto.

## Conexion con PostgreSQL

Crear la base de datos desde `psql` o pgAdmin:

```sql
CREATE DATABASE clima;
```

La aplicacion lee estas variables de entorno:

| Variable | Ejemplo |
|---|---|
| `DB_URL` | `jdbc:postgresql://localhost:5432/clima` |
| `DB_USERNAME` | `postgres` |
| `DB_PASSWORD` | la contraseña local de PostgreSQL |
| `JPA_DDL_AUTO` | `update` en desarrollo, `validate` en producción |
| `JPA_SHOW_SQL` | `true` para depurar SQL |

En PowerShell:

```powershell
$env:DB_USERNAME = "postgres"
$env:DB_PASSWORD = "tu_contraseña"
$env:JPA_DDL_AUTO = "update"
```

Hay un script SQL reproducible en `database/schema.sql`. Se debe ejecutar sobre una base vacia si se desea crear el esquema manualmente. Si se usa `ddl-auto=update`, Hibernate puede crear o actualizar las tablas automaticamente.

## Ejecucion

```powershell
.\mvnw.cmd spring-boot:run
```

La API queda disponible en `http://localhost:8081`.

Para compilar:

```powershell
.\mvnw.cmd clean package
```

## Endpoints

| Recurso | Operaciones principales |
|---|---|
| `/api/ciudades` | GET, POST, PUT `/{id}`, DELETE `/{id}` |
| `/api/estaciones` | GET, POST, PUT `/{id}`, DELETE `/{id}`, GET `/ciudad/{id}` |
| `/api/registros-clima` | GET, POST, PUT `/{id}`, DELETE `/{id}`, GET `/estacion/{id}` |
| `/api/tipos-medicion` | GET, POST, PUT `/{id}`, DELETE `/{id}` |
| `/api/usuarios` | GET, POST, POST `/{id}/roles/{rolId}`, GET `/rol/{nombre}` |
| `/api/roles` | GET, POST |
| `/api/alertas` | GET, POST, GET `/nivel/{nivel}`, GET `/activas/ciudad/{id}` |
| `/api/configuraciones-estacion` | GET, POST |

Consultas adicionales:

- `GET /api/registros-clima/temperatura-superior?valor=30`
- `GET /api/registros-clima/promedio/ciudad/{id}`
- `GET /api/alertas/activas/ciudad/{id}`

## Ejemplos de cuerpos

Crear ciudad:

```json
{
	"nombre": "Manizales",
	"departamento": "Caldas",
	"poblacion": 454000
}
```

Crear estacion:

```json
{
	"nombre": "Estacion Centro",
	"codigo": "MAN-CEN-01",
	"ubicacion": "Centro de Manizales",
	"estado": "ACTIVA",
	"ciudadId": 1
}
```

Crear medicion:

```json
{
	"temperatura": 31.4,
	"humedad": 68,
	"presion": 1012.8,
	"fecha": "2026-10-30T14:30:00",
	"descripcion": "Medicion de la tarde",
	"estacionId": 1,
	"tiposMedicionIds": [1, 2]
}
```

La coleccion importable de Postman esta en `postman/Clima.postman_collection.json`.

## Pruebas

```powershell
.\mvnw.cmd test
```

Las pruebas de contexto necesitan una base PostgreSQL accesible y credenciales validas. Para una entrega completa todavia conviene agregar pruebas de controlador, servicio, repositorio y consultas con una base de prueba.

## Entregables del taller

Ya quedan dentro del proyecto:

- Entidades JPA y repositorios.
- Relaciones 1:1, 1:N y N:M.
- CRUD de ciudades, estaciones, mediciones y tipos de medicion.
- Creacion de usuarios, roles y alertas.
- Consultas derivadas y JPQL.
- Validaciones y respuestas de error.
- Script SQL, modelo relacional y coleccion Postman.

Fuera del codigo se debe preparar y explicar en la sustentacion:

- Diagrama ER exportado como imagen o PDF.
- Justificacion escrita de cardinalidades, restricciones, `mappedBy`, `cascade`, `fetch` y `orphanRemoval`.
- Evidencias de pruebas en Postman.
- Evidencia de tablas y datos en PostgreSQL.
- Configuracion real de credenciales, que no debe subirse al repositorio.
- Si se exige seguridad real, hash de contraseñas y autenticacion/autorizacion con Spring Security.