INSERT INTO tipoi(nombre_tipi,acronimo) VALUES
('Tarjeta de Identidad','TI'),
('Cedula de Ciudadania','CC'),
('Cedula de Extranjeria','CE'),
('Pasaporte','PA');

INSERT INTO rol(nombre_rol) VALUES
('ROLE_ADMIN'),
('ROLE_OPERARIO'),
('ROLE_CLIENTE');

INSERT INTO tipov(nombre_tipv) VALUES
('Moto'),
('Carro');

INSERT INTO plaza(numero) VALUES
('C1','true'),
('C2','true'),
('C3','true'),
('C4','true'),
('C5','true'),
('C6','true'),
('C7','true'),
('C8','true'),
('C9','true'),
('C10','true'),
('C11','true'),
('C12','true'),
('C13','true'),
('C14','true'),
('C15','true'),
('C16','true'),
('C17','true'),
('C18','true'),
('C19','true'),
('C20','true'),
('C21','true'),
('C22','true'),
('C23','true'),
('C24','true'),
('C25','true'),
('M1','true'),
('M2','true'),
('M3','true'),
('M4','true'),
('M5','true'),
('M6','true'),
('M7','true'),
('M8','true'),
('M9','true'),
('M10','true'),
('M11','true'),
('M12','true'),
('M13','true'),
('M14','true'),
('M15','true'),
('M16','true'),
('M17','true'),
('M18','true'),
('M19','true'),
('M20','true'),
('M21','true'),
('M22','true'),
('M23','true'),
('M24','true'),
('M25','true');

INSERT INTO estador(nombre) VALUES 
('Creada'),
('Utilizada'),
('Cancelada');

insert into usuario(nombre,apellido,id_tipoi,ni,email,telefono) values
('Luz','Moreno',2,123456,'correo@correo.com',852741);
/*
ALTER TABLE easyparking.usuario AUTO_INCREMENT = 1;
password: 1234
password encriptado:$2a$10$6m.kB3RqeqD7q.a73swDsOD319/ypTYaJhmxHJDa.veBSASyMx9xS
*/
INSERT INTO acceso(id_usuario,username,encrypted_password,id_rol,estado,descuento) VALUES
(1,'lmoreno1','$2a$10$6m.kB3RqeqD7q.a73swDsOD319/ypTYaJhmxHJDa.veBSASyMx9xS',1,1,0);

/*Graficas*/
SELECT *
FROM (SELECT count(*) AS motos, DATE_FORMAT(f.egreso, "%M %Y") AS fecha_motos FROM Factura f JOIN Vehiculo v ON f.id_vehiculo=v.vehiculo_id WHERE v.id_tipov=1 AND f.egreso BETWEEN "2019-01-01" AND "2020-01-01" GROUP BY fecha_motos) A
INNER JOIN (SELECT count(*) AS carros, DATE_FORMAT(f.egreso, "%M %Y") AS fecha_carros FROM Factura f JOIN Vehiculo v ON f.id_vehiculo=v.vehiculo_id WHERE v.id_tipov=2 AND f.egreso BETWEEN "2019-01-01" AND "2020-01-01" GROUP BY fecha_carros) B
ON a.fecha_motos = b.fecha_carros;

SELECT *
FROM (SELECT count(*) AS motos, DATE_FORMAT(f.egreso, "%Y") AS fecha_motos FROM Factura f JOIN Vehiculo v ON f.id_vehiculo=v.vehiculo_id WHERE v.id_tipov=1 AND f.egreso BETWEEN "2019-01-01" AND "2020-01-01" GROUP BY fecha_motos) A
INNER JOIN (SELECT count(*) AS carros, DATE_FORMAT(f.egreso, "%Y") AS fecha_carros FROM Factura f JOIN Vehiculo v ON f.id_vehiculo=v.vehiculo_id WHERE v.id_tipov=2 AND f.egreso BETWEEN "2019-01-01" AND "2020-01-01" GROUP BY fecha_carros) B
ON a.fecha_motos = b.fecha_carros;

