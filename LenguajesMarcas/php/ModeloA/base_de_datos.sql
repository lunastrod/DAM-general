CREATE DATABASE biblioteca;
USE biblioteca;

CREATE TABLE libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(120) NOT NULL,
    autor VARCHAR(120) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO libros (titulo, autor, precio, stock) VALUES
('Clean Code', 'Robert C. Martin', 34.95, 7),
('Java: How to Program', 'Deitel', 42.5, 5),
('HTML y CSS', 'Jon Duckett', 28.9, 9),
('Eloquent JavaScript', 'Marijn Haverbeke', 31.2, 6),
('Introducción a MySQL', 'Ana Pérez', 22.0, 8),
('Redes para DAM', 'Carlos Elvira', 19.9, 10);