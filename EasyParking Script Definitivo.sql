CREATE DATABASE easyparking;

USE easyparking;

CREATE TABLE rol (
  rol_id INT NOT NULL AUTO_INCREMENT,
  nombre_rol VARCHAR(20) NOT NULL,
  PRIMARY KEY (rol_id)
);

CREATE TABLE estador (
  estador_id INT NOT NULL AUTO_INCREMENT,
  nombre_estado VARCHAR(10) NOT NULL,
  PRIMARY KEY (estador_id)
);

CREATE TABLE tipoi (
  tipoi_id INT NOT NULL AUTO_INCREMENT,
  nombre_tipi VARCHAR(45) NOT NULL,
  acronimo VARCHAR(45) NOT NULL,
  PRIMARY KEY (tipoi_id)
);

CREATE TABLE tipov (
  tipov_id INT NOT NULL AUTO_INCREMENT,
  nombre_tipv VARCHAR(60) NOT NULL,
  descripcion VARCHAR(60) NULL DEFAULT NULL,
  PRIMARY KEY (tipov_id)
);

CREATE TABLE plaza (
  plaza_id INT NOT NULL AUTO_INCREMENT,
  numero VARCHAR(5) NOT NULL,
  estadop BIT(1) NOT NULL,
  PRIMARY KEY (plaza_id)
);

CREATE TABLE usuario (
  usuario_id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NOT NULL,
  apellido VARCHAR(45) NOT NULL,
  id_tipoi INT NOT NULL,
  ni VARCHAR(45) NOT NULL,
  email VARCHAR(100) NOT NULL,
  telefono INT NOT NULL,  
  PRIMARY KEY (usuario_id),
  INDEX id_tipoi_idx (id_tipoi ASC),
  CONSTRAINT id_tipoi
    FOREIGN KEY (id_tipoi)
    REFERENCES tipoi (tipoi_id)
);

CREATE TABLE reserva (
  reserva_id INT NOT NULL AUTO_INCREMENT,
  id_plaza INT NOT NULL,
  placaa VARCHAR(10) NOT NULL,
  creador_por VARCHAR(30) NOT NULL,
  hora TIME(2) NOT NULL,
  fecha DATE NOT NULL,
  id_estador INT NOT NULL,
  PRIMARY KEY (reserva_id),
  INDEX id_plaza_idx (id_plaza ASC),
  INDEX id_estador_idx (id_estador ASC),
  CONSTRAINT id_plaza
    FOREIGN KEY (id_plaza)
    REFERENCES plaza (plaza_id),
   CONSTRAINT id_estador
    FOREIGN KEY (id_estador)
    REFERENCES estador (estador_id)
);
  
CREATE TABLE acceso (
  acceso_id INT NOT NULL AUTO_INCREMENT,
  id_usuario INT NOT NULL,
  username VARCHAR(50) NOT NULL,
  encrypted_password VARCHAR(255) NOT NULL,
  id_rol INT NOT NULL,
  estado BIT(1) NOT NULL,
  descuento BIT(1) NOT NULL,
  expira DATETIME NULL DEFAULT NULL,
  reset_password_token VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (acceso_id),
  INDEX id_usuario_idx (id_usuario ASC),
  INDEX id_rol_idx (id_rol ASC),
  CONSTRAINT id_usuario
    FOREIGN KEY (id_usuario)
    REFERENCES usuario (usuario_id),
  CONSTRAINT id_rol
    FOREIGN KEY (id_rol)
    REFERENCES rol (rol_id)
);
  
CREATE TABLE vehiculo (
  vehiculo_id INT NOT NULL AUTO_INCREMENT,
  id_tipov INT NOT NULL,
  reservo BIT(1) NOT NULL,
  id_reserva INT NULL DEFAULT NULL,
  placab VARCHAR(10) NULL DEFAULT NULL, 
  plazav INT NULL DEFAULT NULL,
  ingreso DATETIME NOT NULL,
  PRIMARY KEY (vehiculo_id),
  INDEX id_tipov_idx (id_tipov ASC),
  INDEX id_reserva_idx (id_reserva ASC),
  INDEX plazav_idx (plazav ASC),
  CONSTRAINT id_tipov
    FOREIGN KEY (id_tipov)
    REFERENCES tipov (tipov_id),
   CONSTRAINT id_reserva
    FOREIGN KEY (id_reserva)
    REFERENCES reserva (reserva_id),
  CONSTRAINT plazav
    FOREIGN KEY (plazav)
    REFERENCES plaza (plaza_id)
);
    
CREATE TABLE factura (
  factura_id INT NOT NULL AUTO_INCREMENT,
  id_acceso INT NOT NULL,
  id_vehiculo INT NOT NULL,
  cobro DOUBLE NOT NULL,
  pago BIT(1) NOT NULL,
  copia BIT(1) NOT NULL,
  egreso DATETIME NULL,
  PRIMARY KEY (factura_id),
  INDEX id_acceso_idx (id_acceso ASC),
  INDEX id_vehiculo_idx (id_vehiculo ASC),
  CONSTRAINT id_acceso
    FOREIGN KEY (id_acceso)
    REFERENCES acceso (acceso_id),
  CONSTRAINT id_vehiculo
    FOREIGN KEY (id_vehiculo)
    REFERENCES vehiculo (vehiculo_id)
);



