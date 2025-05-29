-- crear la base de datos
CREATE DATABASE renttools;
-- cambiar a la base de datso
\c renttools
-- Tabla de usuarios
CREATE TABLE "user" (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(50),
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

-- Tabla de categorías
CREATE TABLE categorias (
    id_categoria SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- Tabla de herramientas
CREATE TABLE herramientas (
    id_herramienta SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    precio_por_dia NUMERIC(10, 2),
    disponible BOOLEAN DEFAULT TRUE,
    estado VARCHAR(50),
    imagen_url TEXT,
    id_proveedor BIGINT REFERENCES "user"(id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de herramienta_categoria (relación muchos a muchos)
CREATE TABLE herramienta_categoria (
    id_herramienta INT REFERENCES herramientas(id_herramienta) ON DELETE CASCADE,
    id_categoria INT REFERENCES categorias(id_categoria) ON DELETE CASCADE,
    PRIMARY KEY (id_herramienta, id_categoria)
);

-- Tabla de historial de estado de herramienta
CREATE TABLE historial_estado_herramienta (
    id_historial SERIAL PRIMARY KEY,
    id_herramienta INT REFERENCES herramientas(id_herramienta) ON DELETE CASCADE,
    estado VARCHAR(50),
    fecha_cambio TIMESTAMP,
    observaciones TEXT
);

-- Tabla de reservas
CREATE TABLE reservas (
    id SERIAL PRIMARY KEY,
    id_herramienta INT REFERENCES herramientas(id_herramienta) ON DELETE CASCADE,
    id_cliente BIGINT REFERENCES "user"(id) ON DELETE CASCADE,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    estado VARCHAR(30) DEFAULT 'PENDIENTE',
    monto NUMERIC(10, 2)
);
