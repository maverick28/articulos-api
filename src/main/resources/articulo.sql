CREATE DATABASE articulosapi;

CREATE TABLE IF NOT EXISTS articulo (
    id VARCHAR(10) NOT NULL PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    descripcion VARCHAR(200),
    precio DECIMAL(10, 2) NOT NULL,
    modelo VARCHAR(10),
    CONSTRAINT chk_precio CHECK (precio >= 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO articulo (id, nombre, descripcion, precio, modelo) VALUES
('A123456789', 'Articulo 1', 'Este es el primer artículo de muestra.', 99.99, 'Modelo1'),
('B234567890', 'Articulo 2', 'Descripción del segundo artículo. Muy útil.', 149.99, 'Modelo2'),
('C345678901', 'Articulo 3', 'Un artículo de muestra para pruebas.', 199.50, 'Modelo3'),
('D456789012', 'Articulo 4', '', 79.99, 'Modelo4'),
('E567890123', 'Articulo 5', NULL, 49.75, 'Modelo5'),
('F678901234', 'Articulo 6', 'Otro artículo para la demostración del sistema.', 59.99, 'Modelo6'),
('G789012345', 'Articulo 7', 'Descripción extensa del artículo para pruebas.', 129.90, 'Modelo7'),
('H890123456', 'Articulo 8', 'Artículo con múltiples usos y funciones.', 89.50, 'Modelo8'),
('I901234567', 'Articulo 9', 'Descripción del artículo número 9.', 159.00, 'Modelo9'),
('J012345678', 'Articulo 10', 'Último artículo en la lista de ejemplo.', 199.99, 'Modelo10');