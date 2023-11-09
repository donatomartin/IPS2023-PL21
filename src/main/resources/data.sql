delete from Empleado;
insert into Empleado(nombre, apellido, dni, fechaNacimiento, salarioAnual, telefono, tipo, posicion) values
	('Donato', 'Martin', '21080919Q', '2003-05-15', 1000000, '666666666', 'nodeportivo', 'jardinero'),
    ('Angel', 'Fernandez', '11111111A', '2003-05-15', 1000000, '666666665', 'nodeportivo', 'jardinero'),
    ('Yago', 'Navajas', '11111111B', '2003-05-15', 1000000, '666666664', 'nodeportivo', 'jardinero'),
    ('Carmen', 'Espinosa', '11111111C', '2003-05-15', 1000000, '666666663', 'nodeportivo', 'jardinero'),
    ('Ana', 'Garcia', '11111111D', '2003-05-15', 1000000, '666666662', 'nodeportivo', 'jardinero'),
    ('David', 'Fernandez', '11111111E', '2003-05-15', 1000000, '666666661', 'nodeportivo', 'jardinero'),
    ('Jose', 'Torres', '11111111F', '2003-05-15', 1000000, '666666660', 'nodeportivo', 'jardinero'),
    ('Miguel', 'Sanchez', '11111111G', '2003-05-15', 1000000, '666666659', 'nodeportivo', 'jardinero'),
    ('Juan', 'Castro', '11111111H', '2003-05-15', 1000000, '666666658', 'nodeportivo', 'jardinero'),
    ('Pedro', 'Ortiz', '11111111I', '2003-05-15', 1000000, '666666657', 'nodeportivo', 'jardinero'),
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
insert into merchandaising(id,nombre,tipo,precio) values (1,'Gorra','Ropa',30);
insert into merchandaising(id,nombre,tipo,precio) values (2,'Balon','Material',20);
insert into merchandaising(id,nombre,tipo,precio) values (3,'Poster','Decoracion',5);
insert into merchandaising(id,nombre,tipo,precio) values (4,'Bufanda','Ropa',10);
insert into merchandaising(id,nombre,tipo,precio) values (5,'Camiseta','Ropa',20);
insert into merchandaising(id,nombre,tipo,precio) values (6,'Cono','Material',5);

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