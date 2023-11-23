delete from Empleado;
insert into Empleado(nombre, apellido, dni, fechaNacimiento, salarioAnual, telefono, tipo, posicion) values
	('Donato', 'Martin', '21080919Q', '2003-05-15', 1000000, '666666666', 'nodeportivo', 'jardineria'),
    ('Angel', 'Fernandez', '11111111A', '2003-05-15', 1000000, '666666665', 'nodeportivo', 'jardineria'),
    ('Yago', 'Navajas', '11111111B', '2003-05-15', 1000000, '666666664', 'nodeportivo', 'jardineria'),
    ('Carmen', 'Espinosa', '11111111C', '2003-05-15', 1000000, '666666663', 'nodeportivo', 'jardineria'),
    ('Ana', 'Garcia', '11111111D', '2003-05-15', 1000000, '666666662', 'nodeportivo', 'jardineria'),
    ('David', 'Fernandez', '11111111E', '2003-05-15', 1000000, '666666661', 'nodeportivo', 'jardineria'),
    ('Jose', 'Torres', '11111111F', '2003-05-15', 1000000, '666666660', 'nodeportivo', 'jardineria'),
    ('Miguel', 'Sanchez', '11111111G', '2003-05-15', 1000000, '666666659', 'nodeportivo', 'jardineria'),
    ('Juan', 'Castro', '11111111H', '2003-05-15', 1000000, '666666658', 'nodeportivo', 'jardineria'),
    ('Pedro', 'Ortiz', '11111111I', '2003-05-15', 1000000, '666666657', 'nodeportivo', 'jardineria'),
    ('Sergio', 'Ramirez', '11111111J', '2003-05-15', 1000000, '666666656', 'deportivo', 'jugador'),
    ('Rafael', 'Ruiz', '11111111K', '2003-05-15', 1000000, '666666655', 'deportivo', 'jugador'),
    ('Alejandro', 'Garcia', '11111111L', '2003-05-15', 1000000, '666666654', 'deportivo', 'jugador'),
    ('Antonio', 'Rodriguez', '11111111M', '2003-05-15', 1000000, '666666653', 'deportivo', 'jugador'),
    ('Carlos', 'Gonzalez', '11111111N', '2003-05-15', 1000000, '666666652', 'deportivo', 'jugador'),
    ('Diego', 'Fernandez', '11111111O', '2003-05-15', 1000000, '666666651', 'deportivo', 'jugador'),
    ('Enrique', 'Lopez', '11111111P', '2003-05-15', 1000000, '666666650', 'deportivo', 'jugador'),
    ('Ernesto', 'Martinez', '11111111Q', '2003-05-15', 1000000, '666666649', 'deportivo', 'jugador'),
    ('Felipe', 'Sanchez', '11111111R', '2003-05-15', 1000000, '666666648', 'deportivo', 'entrenador'),
    ('Javier', 'Perez', '11111111S', '2003-05-15', 1000000, '666666647', 'deportivo', 'entrenador'),
    ('Sofía', 'García', '22222222Q', '1995-08-20', 900000, '611223344', 'deportivo', 'jugador'),
	('Carlos', 'Martínez', '33333333R', '1990-04-10', 1200000, '677889900', 'deportivo', 'jugador'),
	('Laura', 'Hernández', '44444444S', '1987-11-25', 800000, '655443322', 'deportivo', 'jugador'),
	('Javier', 'Pérez', '55555555T', '1998-02-18', 1100000, '622998877', 'deportivo', 'jugador'),
	('María', 'López', '66666666U', '1993-06-30', 950000, '688776655', 'deportivo', 'jugador'),
	('Daniel', 'Rodríguez', '77777777V', '1996-09-05', 850000, '633221100', 'deportivo', 'jugador'),
	('Ana', 'Gómez', '88888888W', '1991-03-12', 1050000, '600112233', 'deportivo', 'jugador'),
	('Pablo', 'Fernández', '99999999X', '1988-07-28', 1150000, '644556677', 'deportivo', 'jugador'),
	('Lucía', 'Díaz', '10101010Y', '2000-12-03', 850000, '677889900', 'deportivo', 'jugador'),
	('Manuel', 'Sánchez', '11111111A', '1985-05-20', 1000000, '688776655', 'deportivo', 'jugador'),
	('Elena', 'Martín', '12121212B', '1994-10-15', 950000, '633221100', 'deportivo', 'jugador'),
	('David', 'Gutiérrez', '13131313C', '1997-01-08', 1100000, '655443322', 'deportivo', 'jugador'),
	('Carmen', 'Ruiz', '14141414D', '1989-08-22', 900000, '677889900', 'deportivo', 'jugador'),
	('Alejandro', 'Jiménez', '15151515E', '1992-04-05', 1050000, '611223344', 'deportivo', 'jugador'),
	('Paula', 'Torres', '16161616F', '1999-11-10', 950000, '600112233', 'deportivo', 'jugador'),
	('Pedro', 'Flores', '17171717G', '1986-06-18', 1000000, '644556677', 'deportivo', 'jugador'),
	('Isabel', 'Vázquez', '18181818H', '1995-03-24', 850000, '622998877', 'deportivo', 'jugador'),
	('Francisco', 'Moreno', '19191919I', '1984-09-07', 1150000, '655443322', 'deportivo', 'jugador'),
	('Raquel', 'Navarro', '20202020J', '1993-12-12', 900000, '677889900', 'deportivo', 'jugador'),
	('Hugo', 'González', '21212121K', '1998-07-05', 1100000, '688776655', 'deportivo', 'jugador');

insert into Empleado(eid, nombre, apellido, dni, fechaNacimiento, salarioAnual, telefono, tipo, posicion) values
    (69, 'Luis', 'Rubiales', 'asdf', '2003-05-15', 100000, '69', 'deportivo', 'entrenador'),
    (70, 'Luis', 'Enrique', 'asdf', '2003-05-15', 100000, '69', 'deportivo', 'entrenador');

delete from Equipo;
insert into Equipo(peid, seid, nombre, categoria, esFilial) values
    (69, 70, 'Oviedo', 'Primera', 'true'),
    (69, 70, 'Sporting', 'Primera', 'true'),
    (69, 70, 'Llanes', 'Primera', 'true'),
    (69, 70, 'Avilés', 'Primera', 'true'),
    (69, 70, 'Barsa', 'Primera', 'true'),
    (69, 70, 'Madrid', 'Primera', 'true');

insert into Juega(eqid, eid) values
    (1, 14),
	(3, 12),
	(2, 17),
	(1, 11),
	(2, 15),
	(3, 18),
	(1, 13),
	(3, 16),
	(1, 38),
	(2, 34),
	(3, 21),
	(2, 22),
	(3, 30),
	(1, 29),
	(3, 40),
	(2, 27),
	(1, 23),
	(3, 35),
	(2, 26),
	(1, 39),
	(2, 24),
	(3, 31),
	(1, 37),
	(3, 28),
	(1, 36),
	(2, 25),
	(3, 32),
	(2, 33);

delete from reserva;
insert into reserva(nombreusuario,cuentabancaria,idinstalacion,precioreserva,fechareserva,horaentrada,horasalida,minutoentrada,minutosalida,fechaventa,horaventa,minutoventa) values
	('aaa','1234567-k', 1,50,'2024-01-01',14,16,30,0,'2023-10-14',14,24),
	('bbb','1234567-k', 2,50,'2024-01-01',14,16,30,0,'2023-10-14',14,24);
	
delete from horarioequipo;
insert into horarioequipo(idequipo,fecha,horaentrada,horasalida,minutoentrada,minutosalida,idinstalacion) values
	('eq1', '2024-01-01', 10, 12, 0, 30, 1),
	('eq2', '2024-01-01', 18, 19, 15, 30, 2);
	
delete from instalacion;
insert into instalacion(nombreinstalacion) values 
	('Campo Real Madrid'),
	('Campo Barcelona FC'),
	('Campo Real Oviedo'),
	('Campo Sporting Gijon'),
	('Campo Atletico Madrid'),
    ('Parque Gijon'),
    ('Parque Oviedo'),
    ('Parque Madrid'),
    ('Cancha Bilbao'),
    ('Pista Madrid');
	
delete from venta;
insert into venta(id, concepto, fecha, hora, minuto, cuantia) VALUES (1,'merchandising', '2023-10-13', '20','05',30),
(2,'entradas', '2020-02-04','20','20',20),
(3, 'merchandising','2013-02-02','20','00',50),
(4, 'reserva','2013-09-09','21','11',30);

delete from merchandaising;
insert into merchandaising(id,nombre,tipo,precio) values 
(1,'Gorra','Ropa',30),(2,'Balon','Material',20),
(3,'Poster','Decoracion',5),(4,'Bufanda','Ropa',10),(5,'Camiseta','Ropa',20),
(6,'Cono','Material',5),(7,'Gorra','Ropa',30),
(8,'Balon','Material',20),(9,'Poster','Decoracion',5),(10,'Bufanda','Ropa',10),
(11,'Camiseta','Ropa',20),(12,'Cono','Material',5),(13,'Gorra','Ropa',30),
(14,'Balon','Material',20),(15,'Poster','Decoracion',5),(16,'Bufanda','Ropa',10),
(17,'Camiseta','Ropa',20),(18,'Cono','Material',5),(19,'Gorra','Ropa',30),
(20,'Balon','Material',20),(21,'Poster','Decoracion',5),(22,'Bufanda','Ropa',10),
(23,'Camiseta','Ropa',20),(24,'Cono','Material',5), (25,'Gorra','Ropa',30),
(26,'Balon','Material',20),(27,'Poster','Decoracion',5),(28,'Bufanda','Ropa',10),
(29,'Camiseta','Ropa',20),(30,'Cono','Material',5),(31,'Gorra','Ropa',30),
(32,'Balon','Material',20),(33,'Poster','Decoracion',5),(34,'Bufanda','Ropa',10),
(35,'Camiseta','Ropa',20),(36,'Cono','Material',5),(37,'Gorra','Ropa',30),
(38,'Balon','Material',20),(39,'Poster','Decoracion',5),(40,'Bufanda','Ropa',10),
(41,'Camiseta','Ropa',20),(42,'Cono','Material',5),(43,'Gorra','Ropa',30),
(44,'Balon','Material',20),(45,'Poster','Decoracion',5),(46,'Bufanda','Ropa',10),
(47,'Camiseta','Ropa',20),(48,'Cono','Material',5),(49,'Gorra','Ropa',30),
(50,'Camiseta','Ropa',20),(51,'Cono','Material',5),(52,'Gorra','Ropa',30),
(53,'Balon','Material',20),(54,'Poster','Decoracion',5),(55,'Bufanda','Ropa',10),
(56,'Camiseta','Ropa',20),(57,'Cono','Material',5),(58,'Bufanda','Ropa',10),
(59,'Camiseta','Ropa',20),(60,'Cono','Material',5);

delete from ventaMerchandising;
insert into ventaMerchandising(id, idProducto, cantidad) VALUES
(1,1,1),
(3, 2,1),
(3,4,3);


delete from Partido;
insert into Partido(id, idEquipo, equipoVisitante, fecha, suplemento) values ('1','1', 'EquipoVisitante', '2023-11-09', 10);
insert into Partido(id, idEquipo, equipoVisitante, fecha, suplemento) values ('2','1', 'EquipoVisitante2', '2023-11-16', 0);

delete from Abonado;
insert into Abonado(id) values('1'); 

delete from accion;
insert into accion(idAccionista,precioCompra,enVenta,precioVenta) values
	(1, 34.67, 1, 34.67),
	(1, 34.67, 0, 34.67),
	(2, 34.67, 1, 34.67),
	(2, 34.67, 0, 34.67),
	(1, 34.67, 1, 34.67),
	(1, 34.67, 0, 34.67),
	(2, 34.67, 1, 34.67),
	(2, 34.67, 0, 34.67),
	(1, 34.67, 1, 34.67),
	(1, 34.67, 0, 34.67),
	(2, 34.67, 1, 34.67),
	(2, 34.67, 0, 34.67),
	(1, 34.67, 1, 34.67),
	(1, 34.67, 0, 34.67),
	(2, 34.67, 1, 34.67),
	(2, 34.67, 0, 34.67),
	(1, 34.67, 1, 34.67),
	(1, 34.67, 0, 34.67),
	(2, 34.67, 1, 34.67),
	(2, 34.67, 0, 34.67),
	(1, 34.67, 1, 34.67),
	(1, 34.67, 0, 34.67),
	(2, 34.67, 1, 34.67),
	(2, 34.67, 0, 34.67),
	(1, 34.67, 1, 34.67),
	(1, 34.67, 0, 34.67),
	(2, 34.67, 1, 34.67),
	(2, 34.67, 0, 34.67),
	(1, 34.67, 1, 34.67),
	(2, 34.67, 0, 34.67);
	
delete from accionista;
insert into accionista(nombreAccionista,apellidoAccionista,dniAccionista,cuentaBancaria,numeroAcciones,porcentajeCapital) values
	('aaa', 'bbb', '1234K', 'abcd', 15, 50.0),
	('ccc', 'ddd', '5678X', 'efgh', 15, 50.0);
	
delete from ampliacioncapital;
insert into ampliacioncapital(faseUno,faseDos,faseTres,capitalTotal,precioAccion,accionesTotales,fase,vendidas) values
	(0,0,0,1040.1,34.67,30, 'Fuera fase',0);
	
delete from lesion;
insert into lesion(eid, causa, pid, enid, descripcion, fecha, tipo) values
	(14, 'causa ajena', null, null, 'Gastroenteritis', '2023-11-21', 'Enfermedad');
