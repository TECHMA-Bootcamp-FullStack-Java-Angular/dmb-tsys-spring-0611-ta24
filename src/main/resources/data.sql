DROP TABLE IF EXISTS trabajador;

CREATE TABLE trabajador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(250),
    apellido VARCHAR(250),
    dni INT,
    trabajo ENUM('DM', 'DIVER', 'TENDER', 'SUPERVISOR'),
    salario INT
);

INSERT INTO trabajador (nombre, apellido, dni, trabajo, salario) VALUES ('David', 'Maza', 123456789, 'SUPERVISOR', 2500);
INSERT INTO trabajador (nombre, apellido, dni, trabajo, salario) VALUES ('Manuel', 'Lopez', 456789123, 'DIVER', 2000);
INSERT INTO trabajador (nombre, apellido, dni, trabajo, salario) VALUES ('Daniel', 'Segura', 987654123, 'TENDER', 1900);
