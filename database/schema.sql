CREATE TABLE ciudades (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    departamento VARCHAR(100) NOT NULL,
    poblacion BIGINT NOT NULL CHECK (poblacion > 0)
);

CREATE TABLE estaciones (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    codigo VARCHAR(50) NOT NULL UNIQUE,
    ubicacion VARCHAR(150) NOT NULL,
    estado VARCHAR(30) NOT NULL,
    ciudad_id BIGINT NOT NULL REFERENCES ciudades(id)
);

CREATE TABLE configuraciones_estacion (
    id BIGSERIAL PRIMARY KEY,
    intervalo_minutos INTEGER NOT NULL CHECK (intervalo_minutos > 0),
    proveedor VARCHAR(100) NOT NULL,
    estacion_id BIGINT NOT NULL UNIQUE REFERENCES estaciones(id)
);

CREATE TABLE tipos_medicion (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(60) NOT NULL UNIQUE,
    unidad VARCHAR(20) NOT NULL,
    descripcion VARCHAR(200)
);

CREATE TABLE registros_clima (
    id BIGSERIAL PRIMARY KEY,
    temperatura DOUBLE PRECISION NOT NULL,
    humedad INTEGER NOT NULL CHECK (humedad BETWEEN 0 AND 100),
    presion DOUBLE PRECISION NOT NULL,
    fecha TIMESTAMP NOT NULL,
    descripcion VARCHAR(50),
    estacion_id BIGINT NOT NULL REFERENCES estaciones(id)
);

CREATE TABLE registros_tipos_medicion (
    registro_clima_id BIGINT NOT NULL REFERENCES registros_clima(id) ON DELETE CASCADE,
    tipo_medicion_id BIGINT NOT NULL REFERENCES tipos_medicion(id),
    PRIMARY KEY (registro_clima_id, tipo_medicion_id)
);

CREATE TABLE usuarios (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(120) NOT NULL,
    correo VARCHAR(150) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL
);

CREATE TABLE roles (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    descripcion VARCHAR(200)
);

CREATE TABLE usuarios_roles (
    usuario_id BIGINT NOT NULL REFERENCES usuarios(id) ON DELETE CASCADE,
    rol_id BIGINT NOT NULL REFERENCES roles(id) ON DELETE CASCADE,
    PRIMARY KEY (usuario_id, rol_id)
);

CREATE TABLE alertas (
    id BIGSERIAL PRIMARY KEY,
    descripcion VARCHAR(250) NOT NULL,
    nivel VARCHAR(30) NOT NULL,
    fecha TIMESTAMP NOT NULL,
    activa BOOLEAN NOT NULL,
    registro_clima_id BIGINT NOT NULL REFERENCES registros_clima(id)
);

CREATE INDEX idx_estaciones_ciudad ON estaciones(ciudad_id);
CREATE INDEX idx_registros_estacion ON registros_clima(estacion_id);
CREATE INDEX idx_registros_fecha ON registros_clima(fecha);
CREATE INDEX idx_alertas_nivel ON alertas(nivel);
CREATE INDEX idx_alertas_activas ON alertas(activa);
