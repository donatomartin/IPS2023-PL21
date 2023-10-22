delete from EmpleadoNoDeportivo;
insert into EmpleadoNoDeportivo(eid, nombre, apellido, dni, fechaNacimiento, salarioAnual, telefono, posicion) values
	(1, 'Donato', 'Martin', '21080919Q', '2003-05-15', 1000000, '666666666', 'Tienda'),
    (2, 'Angel', 'Fernandez', '11111111A', '2003-05-15', 1000000, '666666665', 'Tienda'),
    (3, 'Yago', 'Navajas', '11111111B', '2003-05-15', 1000000, '666666664', 'Tienda'),
    (4, 'Carmen', 'Espinosa', '11111111C', '2003-05-15', 1000000, '666666663', 'Tienda'),
    (5, 'Ana', 'Garcia', '11111111D', '2003-05-15', 1000000, '666666662', 'Tienda'),
    (6, 'David', 'Fernandez', '11111111E', '2003-05-15', 1000000, '666666661', 'Tienda'),
    (7, 'Jose', 'Torres', '11111111F', '2003-05-15', 1000000, '666666660', 'Tienda'),
    (8, 'Miguel', 'Sanchez', '11111111G', '2003-05-15', 1000000, '666666659', 'Tienda'),
    (9, 'Juan', 'Castro', '11111111H', '2003-05-15', 1000000, '666666658', 'Tienda'),
    (10, 'Pedro', 'Ortiz', '11111111I', '2003-05-15', 1000000, '666666657', 'Tienda'),
    (11, 'Sergio', 'Ramirez', '11111111J', '2003-05-15', 1000000, '666666656', 'Tienda'),
    (12, 'Rafael', 'Ruiz', '11111111K', '2003-05-15', 1000000, '666666655', 'Tienda'),
    (13, 'Alejandro', 'García', '11111111L', '2003-05-15', 1000000, '666666654', 'Tienda'),
    (14, 'Antonio', 'Rodríguez', '11111111M', '2003-05-15', 1000000, '666666653', 'Tienda'),
    (15, 'Carlos', 'González', '11111111N', '2003-05-15', 1000000, '666666652', 'Tienda'),
    (16, 'Diego', 'Fernández', '11111111O', '2003-05-15', 1000000, '666666651', 'Tienda'),
    (17, 'Enrique', 'López', '11111111P', '2003-05-15', 1000000, '666666650', 'Tienda'),
    (18, 'Ernesto', 'Martínez', '11111111Q', '2003-05-15', 1000000, '666666649', 'Tienda'),
    (19, 'Felipe', 'Sánchez', '11111111R', '2003-05-15', 1000000, '666666648', 'Tienda'),
    (20, 'Javier', 'Pérez', '11111111S', '2003-05-15', 1000000, '666666647', 'Tienda');

delete from empleadoDeportivo;
insert into empleadoDeportivo(nombre,apellido,dni,fechaNacimiento,salarioAnual,telefono,posicion) values
	('eee','fff','12345678K','1985-02-04',10000000, '1234567890', 'Jugador'),
	('ggg','hhh','12345678K','1985-02-04',10000000, '1234567890', 'Tecnico'),
	('iii','jjj','12345678K','1985-02-04',10000000, '1234567890', 'Jugador');

delete from JugadorProfesional;
insert into JugadorProfesional(eid, nombre, apellido, dni, fechaNacimiento, salarioAnual, telefono, posicion) values
	(1, 'Donato', 'Martin', '21080919Q', '15-05-2003', 1000000, '666666666', "delantero"),
    (2, 'Angel', 'Fernandez', '11111111A', '15-05-2003', 1000000, '666666665', "delantero"),
    (3, 'Yago', 'Navajas', '11111111B', '15-05-2003', 1000000, '666666664', "delantero"),
    (4, 'Carmen', 'Espinosa', '11111111C', '15-05-2003', 1000000, '666666663', "delantero"),
    (5, 'Ana', 'Garcia', '11111111D', '15-05-2003', 1000000, '666666662', "delantero"),
    (6, 'David', 'Fernandez', '11111111E', '15-05-2003', 1000000, '666666661', "delantero"),
    (7, 'Jose', 'Torres', '11111111F', '15-05-2003', 1000000, '666666660', "delantero"),
    (8, 'Miguel', 'Sanchez', '11111111G', '15-05-2003', 1000000, '666666659', "delantero"),
    (9, 'Juan', 'Castro', '11111111H', '15-05-2003', 1000000, '666666658', "delantero"),
    (10, 'Pedro', 'Ortiz', '11111111I', '15-05-2003', 1000000, '666666657', "delantero"),
    (11, 'Sergio', 'Ramirez', '11111111J', '15-05-2003', 1000000, '666666656', "delantero"),
    (12, 'Rafael', 'Ruiz', '11111111K', '15-05-2003', 1000000, '666666655', "delantero"),
    (13, 'Alejandro', 'García', '11111111L', '15-05-2003', 1000000, '666666654', "delantero"),
    (14, 'Antonio', 'Rodríguez', '11111111M', '15-05-2003', 1000000, '666666653', "delantero"),
    (15, 'Carlos', 'González', '11111111N', '15-05-2003', 1000000, '666666652', "delantero"),
    (16, 'Diego', 'Fernández', '11111111O', '15-05-2003', 1000000, '666666651', "delantero"),
    (17, 'Enrique', 'López', '11111111P', '15-05-2003', 1000000, '666666650', "delantero"),
    (18, 'Ernesto', 'Martínez', '11111111Q', '15-05-2003', 1000000, '666666649', "delantero"),
    (19, 'Felipe', 'Sánchez', '11111111R', '15-05-2003', 1000000, '666666648', "delantero"),
    (20, 'Javier', 'Pérez', '11111111S', '15-05-2003', 1000000, '666666647', "delantero");
    
delete from reserva;
insert into reserva(nombreusuario,cuentabancaria,idinstalacion,precioreserva,fechareserva,horaentrada,horasalida,minutoentrada,minutosalida,fechaventa,horaventa,minutoventa) values
	('aaa','1234567-k', 'c1',50,'2024-01-01',14,16,30,0,'2023-10-14',14,24),
	('bbb','1234567-k', 'c2',50,'2024-01-01',14,16,30,0,'2023-10-14',14,24);
	
delete from horarioequipo;
insert into horarioequipo(idequipo,fecha,horaentrada,horasalida,minutoentrada,minutosalida,idinstalacion) values
	('eq1', '2024-01-01', 10, 12, 0, 30, 'c1'),
	('eq2', '2024-01-01', 18, 19, 15, 30, 'c1');
	
delete from instalacion;
insert into instalacion(id, nombreinstalacion) values 
	('c1', 'Campo 1'),
	('c2', 'Campo 2'),
	('c3', 'Campo 3'),
	('c4', 'Campo 4'),
	('c5', 'Campo 5');
