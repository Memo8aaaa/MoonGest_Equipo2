CREATE DATABASE IF NOT EXISTS moongest;
USE moongest;
-- Tabla: usuarios
CREATE TABLE usuarios (
  idusuario INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(25) NOT NULL,
  contrasena VARCHAR(255) NOT NULL,
  rol VARCHAR(10) NOT NULL,
  PRIMARY KEY (idusuario)
);

-- Tabla: clientas
CREATE TABLE clientas (
  idclienta INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NOT NULL,
  paterno VARCHAR(45),
  materno VARCHAR(45) NULL,
  telefono VARCHAR(15) NOT NULL,
  fecha_primeravisita DATE NOT NULL,
  notas_alergia TEXT NULL,
  notas_preferencia TEXT NULL,
  PRIMARY KEY (idclienta)
);

-- Tabla: catalogo_servicios
CREATE TABLE catalogo_servicios (
  idservicio INT NOT NULL AUTO_INCREMENT,
  nombre_servicio VARCHAR(50) NOT NULL,
  descripcion TEXT NOT NULL,
  duracion_estimada TIME NOT NULL,
  precio_estandar DECIMAL(10,2) NOT NULL,
  activo TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (idservicio)
);

-- Tabla: citas
CREATE TABLE citas (
  idcita INT NOT NULL AUTO_INCREMENT,
  idusuario INT NOT NULL,
  idclienta INT NOT NULL,
  idservicio INT NOT NULL,
  fecha_cita DATE NOT NULL,
  hora_cita TIME NOT NULL,
  estado_cita TINYINT NOT NULL DEFAULT 1,
  notas TEXT NULL,
  PRIMARY KEY (idcita),
  CONSTRAINT fk_citas_usuario
    FOREIGN KEY (idusuario)
    REFERENCES usuarios (idusuario)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_citas_clientas
    FOREIGN KEY (idclienta)
    REFERENCES clientas (idclienta)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_citas_servicios
    FOREIGN KEY (idservicio)
    REFERENCES catalogo_servicios (idservicio)
    ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- Tabla: pagos
CREATE TABLE pagos (
  idpago INT NOT NULL AUTO_INCREMENT,
  idcita INT NOT NULL,
  metodo_pago ENUM('Efectivo', 'Tarjeta', 'Transferencia') NOT NULL,
  tipo_pago ENUM('Adelanto', 'Pago completo') NOT NULL,
  monto_pagado DECIMAL(10,2) NOT NULL,
  fecha_pago DATETIME NOT NULL,
  referencia VARCHAR(50) NULL,
  PRIMARY KEY (idpago),
  CONSTRAINT fk_pagos_cita
    FOREIGN KEY (idcita)
    REFERENCES citas (idcita)
    ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- Tabla: notificaciones
CREATE TABLE notificaciones (
  idnotificacion INT NOT NULL AUTO_INCREMENT,
  idcita INT NOT NULL,
  fecha_envio DATETIME NOT NULL,
  tipo_notificacion ENUM('RECORDATORIO', 'POLITICAS', 'CONFIRMACION') NOT NULL,
  estado ENUM('Programada', 'Enviada', 'Fallida') NOT NULL,
  PRIMARY KEY (idnotificacion),
  CONSTRAINT fk_notificaciones_cita
    FOREIGN KEY (idcita)
    REFERENCES citas (idcita)
    ON DELETE NO ACTION ON UPDATE NO ACTION
);


ALTER TABLE catalogo_servicios
  ADD COLUMN categoria VARCHAR(20) NOT NULL DEFAULT 'pestañas',
  ADD COLUMN precio_retoque DECIMAL(10,2) NULL;
