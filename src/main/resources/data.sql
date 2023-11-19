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
    ('Javier', 'Perez', '11111111S', '2003-05-15', 1000000, '666666647', 'deportivo', 'entrenador');

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
    (1,11),
    (2,12),
    (3,13);

delete from reserva;
insert into reserva(nombreusuario,cuentabancaria,idinstalacion,precioreserva,fechareserva,horaentrada,horasalida,minutoentrada,minutosalida,fechaventa,horaventa,minutoventa) values
	('aaa','1234567-k', 1,50,'2024-01-01',12,14,30,0,'2023-10-14',14,24),
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
(4, 'reserva','2023-10-14','14','24',50),
(5, 'accion', '2023-11-19', '12', '00', 34.67);


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
