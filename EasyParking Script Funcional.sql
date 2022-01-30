CREATE DATABASE easyparking;

USE easyparking;

CREATE TABLE rol (
  rol_id INT NOT NULL AUTO_INCREMENT,
  nombre_rol VARCHAR(20) NOT NULL,
  PRIMARY KEY (rol_id)
);

CREATE TABLE estado (
  estado_id INT NOT NULL AUTO_INCREMENT,
  estado_reserva VARCHAR(20) NOT NULL,
  PRIMARY KEY (estado_id)
);

CREATE TABLE tarificacion (
  tarificacion_id INT NOT NULL AUTO_INCREMENT,
  tipo_tarificacion VARCHAR(10) NOT NULL,
  PRIMARY KEY (tarificacion_id)
);

CREATE TABLE descuento (
  descuento_id INT NOT NULL AUTO_INCREMENT,
  tiene_descuento BIT(1) NOT NULL,
  expira DATE NULL DEFAULT NULL,
  PRIMARY KEY (descuento_id)
);

CREATE TABLE tidentificacion (
  tipoi_id INT NOT NULL AUTO_INCREMENT,
  tipo_nombre VARCHAR(60) NOT NULL,
  acronimo VARCHAR(50) NOT NULL,
  PRIMARY KEY (tipoi_id)
);

CREATE TABLE tipov (
  tipov_id INT NOT NULL AUTO_INCREMENT,
  nombre_tipo VARCHAR(10) NOT NULL,
  descripcion VARCHAR(60) NULL DEFAULT NULL,
  PRIMARY KEY (tipov_id)
);

CREATE TABLE parqueadero (
  parqueadero_id INT NOT NULL AUTO_INCREMENT,
  nombre_par VARCHAR(50) NOT NULL,
  direccion_par VARCHAR(50) NOT NULL,
  cantidad_plazas INT NOT NULL,
  nombre_admin VARCHAR(30) NOT NULL,
  PRIMARY KEY (parqueadero_id)
);

CREATE TABLE plaza (
  plaza_id INT NOT NULL AUTO_INCREMENT,
  id_parqueadero INT NOT NULL,
  numero_plaza VARCHAR(5) NOT NULL,
  estado_plaza BIT(1) NOT NULL,
  PRIMARY KEY (plaza_id),
  INDEX parqueadero_plaza_idx (id_parqueadero ASC),
  CONSTRAINT id_parqueadero
    FOREIGN KEY (id_parqueadero)
    REFERENCES parqueadero (parqueadero_id)
);

CREATE TABLE usuario (
  usuario_id INT NOT NULL AUTO_INCREMENT,
  id_tipoi INT NOT NULL,
  nombre_usuario VARCHAR(50) NOT NULL,
  apellido_usuario VARCHAR(50) NOT NULL,  
  identificacion_usuario VARCHAR(50) NOT NULL,
  email_usuario VARCHAR(100) NOT NULL,
  telefono_usuario INT NOT NULL,  
  PRIMARY KEY (usuario_id),
  INDEX tidentificacion_usuario_idx (id_tipoi ASC),
  CONSTRAINT id_tipoi
    FOREIGN KEY (id_tipoi)
    REFERENCES tidentificacion (tipoi_id)
);

CREATE TABLE reserva (
  reserva_id INT NOT NULL AUTO_INCREMENT,
  id_plaza INT NOT NULL,
  id_estado INT NOT NULL,
  placa_reserva VARCHAR(10) NOT NULL,
  hora_reserva TIME NOT NULL,
  fecha_reserva DATE NOT NULL,  
  creador_por VARCHAR(50) NOT NULL,  
  PRIMARY KEY (reserva_id),
  INDEX plaza_reserva_idx (id_plaza ASC),
  INDEX estado_reserva_idx (id_estado ASC),
  CONSTRAINT id_plaza
    FOREIGN KEY (id_plaza)
    REFERENCES plaza (plaza_id),
   CONSTRAINT id_estado
    FOREIGN KEY (id_estado)
    REFERENCES estado (estado_id)
);
  
CREATE TABLE acceso (
  acceso_id INT NOT NULL AUTO_INCREMENT,
  id_usuario INT NOT NULL,
  id_rol INT NOT NULL,
  id_descuento INT NOT NULL,
  username VARCHAR(50) NOT NULL,
  encrypted_password VARCHAR(255) NOT NULL, 
  reset_password_token VARCHAR(30) NULL DEFAULT NULL,
  estado_acceso BIT(1) NOT NULL, 
  PRIMARY KEY (acceso_id),
  INDEX usuario_acceso_idx (id_usuario ASC),
  INDEX rol_acceso_idx (id_rol ASC),
  INDEX descuento_acceso_idx (id_descuento ASC),
  CONSTRAINT id_usuario
    FOREIGN KEY (id_usuario)
    REFERENCES usuario (usuario_id),
  CONSTRAINT id_rol
    FOREIGN KEY (id_rol)
    REFERENCES rol (rol_id),
  CONSTRAINT id_descuento
    FOREIGN KEY (id_descuento)
    REFERENCES descuento (descuento_id)
);
  
CREATE TABLE vehiculo (
  vehiculo_id INT NOT NULL AUTO_INCREMENT,
  id_tipov INT NOT NULL,
  id_reserva INT NULL DEFAULT NULL,
  plaza_vehiculo INT NULL DEFAULT NULL,  
  placa_vehiculo VARCHAR(10) NULL DEFAULT NULL, 
  reservo_plaza BIT(1) NOT NULL,  
  ingreso_veh DATETIME NOT NULL,
  utilizando BIT(1) NOT NULL,
  PRIMARY KEY (vehiculo_id),
  INDEX tipov_vehiculo_idx (id_tipov ASC),
  INDEX reserva_vehiculo_idx (id_reserva ASC),
  INDEX plaza_vehiculo_idx (plaza_vehiculo ASC),
  CONSTRAINT id_tipov
    FOREIGN KEY (id_tipov)
    REFERENCES tipov (tipov_id),
   CONSTRAINT id_reserva
    FOREIGN KEY (id_reserva)
    REFERENCES reserva (reserva_id),
  CONSTRAINT plaza_vehiculo
    FOREIGN KEY (plaza_vehiculo)
    REFERENCES plaza (plaza_id)
);
    
CREATE TABLE factura (
  factura_id INT NOT NULL AUTO_INCREMENT,
  id_acceso INT NOT NULL,
  id_vehiculo INT NOT NULL,
  id_tarificacion INT NOT NULL,
  cobro DOUBLE NOT NULL,
  pago BIT(1) NOT NULL,
  copia BIT(1) NOT NULL,
  egreso DATETIME NOT NULL,
  PRIMARY KEY (factura_id),
  INDEX acceso_factura_idx (id_acceso ASC),
  INDEX vehiculo_factura_idx (id_vehiculo ASC),
  INDEX tarificacion_factura_idx (id_tarificacion ASC),
  CONSTRAINT id_acceso
    FOREIGN KEY (id_acceso)
    REFERENCES acceso (acceso_id),
  CONSTRAINT id_vehiculo
    FOREIGN KEY (id_vehiculo)
    REFERENCES vehiculo (vehiculo_id),
  CONSTRAINT id_tarificacion
    FOREIGN KEY (id_tarificacion)
    REFERENCES tarificacion (tarificacion_id)
);



