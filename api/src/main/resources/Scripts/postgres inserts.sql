
-- Insertar categorías
INSERT INTO categorias (nombre) VALUES ('Eléctrico');
INSERT INTO categorias (nombre) VALUES ('Construcción');
INSERT INTO categorias (nombre) VALUES ('Jardinería');

-- Insertar usuarios cliente y proveedor
INSERT INTO "user" (first_name, last_name, email, phone, password, role) VALUES
('Admin','Principal','admin@example.com','+1234567890','$2a$10$ERc/fuoFB5ErJ7LPek2u2e4a6dEqjFGYT215ug18LHhFlQGkv8znO', 'ROLE_ADMINISTRATOR'),
('Juan', 'Cliente', 'cliente@example.com', '+1111111111', '$2a$10$ERc/fuoFB5ErJ7LPek2u2e4a6dEqjFGYT215ug18LHhFlQGkv8znO', 'ROLE_CUSTOMER'),
('Lucía', 'Proveedor', 'proveedor@example.com', '+2222222222', '$2a$10$ERc/fuoFB5ErJ7LPek2u2e4a6dEqjFGYT215ug18LHhFlQGkv8znO', 'ROLE_PROVIDER');

-- Insertar herramientas
INSERT INTO herramientas (nombre, descripcion, precio_por_dia, disponible, estado, imagen_url, id_proveedor) VALUES
('Taladro Bosch', 'Taladro de impacto 650W', 20.00, TRUE, 'Excelente', 'https://img1.jpg', 2),
('Sierra Circular Makita', 'Sierra de disco 1200W', 25.00, TRUE, 'Bueno', 'https://img2.jpg', 2);

-- Asociar herramientas a categorías
INSERT INTO herramienta_categoria (id_herramienta, id_categoria) VALUES (1, 1); 
INSERT INTO herramienta_categoria (id_herramienta, id_categoria) VALUES (2, 2);

-- Insertar reservas
INSERT INTO reservas (id_herramienta, id_cliente, fecha_inicio, fecha_fin, estado, monto) VALUES
(1, 1, '2025-06-01', '2025-06-03', 'PENDIENTE', 40.00),
(2, 1, '2025-06-05', '2025-06-07', 'PENDIENTE', 50.00);

-- Insertar historial de estado de herramienta
INSERT INTO historial_estado_herramienta (id_herramienta, estado, fecha_cambio, observaciones) VALUES
(1, 'Disponible', NOW(), 'Herramienta ingresada al sistema'),
(2, 'Disponible', NOW(), 'Herramienta en buen estado lista para uso');
