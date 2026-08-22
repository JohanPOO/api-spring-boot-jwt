CREATE TABLE persona (
    id SERIAL PRIMARY KEY NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    estado BOOLEAN
);

CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    contraseña VARCHAR(50) NOT NULL,
    persona_id INT UNIQUE NOT NULL,

    CONSTRAINT fk_persona_usuario
        FOREIGN KEY (persona_id)
        REFERENCES persona(id)
        ON DELETE CASCADE
);

ALTER TABLE usuario
    ALTER COLUMN contraseña TYPE VARCHAR(200);

CREATE TABLE paciente (
    id SERIAL PRIMARY KEY,
    rol VARCHAR(30) NOT NULL,
    estado BOOLEAN NOT NULL,
    persona_id INT UNIQUE NOT NULL,

    CONSTRAINT fk_persona_paciente
        FOREIGN KEY (persona_id)
        REFERENCES persona(id)
        ON DELETE CASCADE
);

CREATE TABLE empleado (
    id SERIAL PRIMARY KEY,
    rol VARCHAR(30) NOT NULL,
    estado BOOLEAN NOT NULL,
    persona_id INT UNIQUE NOT NULL,

    CONSTRAINT fk_persona_empleado
        FOREIGN KEY (persona_id)
        REFERENCES persona(id)
        ON DELETE CASCADE
);

CREATE TABLE especialidad (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    estado BOOLEAN NOT NULL
);

CREATE TABLE medicoespecialidad (
    id SERIAL PRIMARY KEY,
    empleado_id BIGINT,
    especialidad_id BIGINT,

    FOREIGN KEY (empleado_id)
        REFERENCES empleado(id),

    FOREIGN KEY (especialidad_id)
        REFERENCES especialidad(id)
);

CREATE TABLE atencion (
    id SERIAL PRIMARY KEY,
    fecha DATE NOT NULL,
    motivo VARCHAR(100) NOT NULL,
    estado BOOLEAN NOT NULL,
    paciente_id BIGINT,
    empleado_id BIGINT,

    FOREIGN KEY (paciente_id)
        REFERENCES paciente(id),

    FOREIGN KEY (empleado_id)
        REFERENCES empleado(id)
);

