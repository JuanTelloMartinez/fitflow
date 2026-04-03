CREATE DATABASE IF NOT EXISTS FitFlow;
USE FitFlow;

CREATE TABLE Usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefono VARCHAR(15),
    fecha_nacimiento DATE,
    direccion VARCHAR(150),
    frecuencia_pago ENUM('mensual', 'bimestral', 'trimestral') DEFAULT 'mensual',
    nivel_gamificacion INT DEFAULT 0,
    estado ENUM('activo', 'baja') DEFAULT 'activo'
);

CREATE TABLE Empleado (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefono VARCHAR(15),
    rol ENUM('entrenador', 'administrador', 'recepcionista') NOT NULL,
    fecha_contratacion DATE,
    salario DECIMAL(10,2)
);

CREATE TABLE Clase (
    id_clase INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    aforo_maximo INT,
    fecha_inicio DATE,
    fecha_fin DATE,
    id_empleado INT,
    FOREIGN KEY (id_empleado) REFERENCES Empleado(id_empleado)
        ON UPDATE CASCADE
        ON DELETE SET NULL
);

CREATE TABLE Usuario_Clase (
    id_usuario INT,
    id_clase INT,
    fecha_inscripcion DATE DEFAULT CURRENT_DATE,
    asistencias INT DEFAULT 0,
    PRIMARY KEY (id_usuario, id_clase),
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY (id_clase) REFERENCES Clase(id_clase)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE Cuota (
    id_cuota INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    importe DECIMAL(8,2) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    estado_pago ENUM('pagado', 'pendiente', 'retrasado') DEFAULT 'pendiente',
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE Asistencia (
    id_asistencia INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_clase INT NULL,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    tipo ENUM('libre', 'clase') DEFAULT 'libre',
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY (id_clase) REFERENCES Clase(id_clase)
        ON UPDATE CASCADE
        ON DELETE SET NULL
);

CREATE TABLE Entrenamiento (
    id_entrenamiento INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    objetivo VARCHAR(100),
    fecha_creacion DATE DEFAULT CURRENT_DATE,
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE Ejercicio (
    id_ejercicio INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    grupo_muscular VARCHAR(50)
);

CREATE TABLE Entrenamiento_Ejercicio (
    id_entrenamiento INT,
    id_ejercicio INT,
    series INT,
    repeticiones INT,
    descanso INT,
    PRIMARY KEY (id_entrenamiento, id_ejercicio),
    FOREIGN KEY (id_entrenamiento) REFERENCES Entrenamiento(id_entrenamiento)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY (id_ejercicio) REFERENCES Ejercicio(id_ejercicio)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

CREATE TABLE Gamificacion (
    id_usuario INT PRIMARY KEY,
    puntos_totales INT DEFAULT 0,
    nivel VARCHAR(50),
    ultima_actualizacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
