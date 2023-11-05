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
	
delete from venta;
insert into venta(id, concepto, fecha, hora, minuto, cuantia) VALUES (1,'merchandising', '2023-10-13', '20','05',30),
(2,'entradas', '2020-02-04','20','20',20),
(3, 'merchandising','2013-02-02','20','00',50),
(4, 'reserva','2013-09-09','21','11',30);

delete from merchandaising;
insert into merchandaising(nombre,tipo,precio) values ('Gorra','Ropa',10);
insert into merchandaising(nombre,tipo,precio) values ('Balon','Material',20);
insert into merchandaising(nombre,tipo,precio) values ('Poster','Decoracion',5);
insert into merchandaising(nombre,tipo,precio) values ('Bufanda','Ropa',10);
insert into merchandaising(nombre,tipo,precio) values ('Camiseta','Ropa',20);
insert into merchandaising(nombre,tipo,precio) values ('Cono','Material',5);
insert into merchandaising(nombre,tipo,precio) values ('a','Ropa',10);
insert into merchandaising(nombre,tipo,precio) values ('B','Material',20);
insert into merchandaising(nombre,tipo,precio) values ('c','Decoracion',5);
insert into merchandaising(nombre,tipo,precio) values ('d','Ropa',10);
insert into merchandaising(nombre,tipo,precio) values ('e','Ropa',20);
insert into merchandaising(nombre,tipo,precio) values ('f','Material',5);
insert into merchandaising(nombre,tipo,precio) values ('g','Ropa',10);
insert into merchandaising(nombre,tipo,precio) values ('h','Material',20);
insert into merchandaising(nombre,tipo,precio) values ('i','Decoracion',5);
insert into merchandaising(nombre,tipo,precio) values ('j','Ropa',10);
insert into merchandaising(nombre,tipo,precio) values ('k','Ropa',20);
insert into merchandaising(nombre,tipo,precio) values ('l','Material',5);
insert into merchandaising(nombre,tipo,precio) values ('m','Ropa',10);
insert into merchandaising(nombre,tipo,precio) values ('n','Material',20);
insert into merchandaising(nombre,tipo,precio) values ('o','Decoracion',5);
insert into merchandaising(nombre,tipo,precio) values ('p','Ropa',10);
insert into merchandaising(nombre,tipo,precio) values ('q','Ropa',20);
insert into merchandaising(nombre,tipo,precio) values ('r','Material',5);

delete from ventaMerchandising;
insert into ventaMerchandising(id, concepto, fecha, hora, minuto, cuantia, producto, unidades, precioPorProducto) VALUES
(1,'merchandising','2023-10-13', '20','05',30, 'camiseta', 3,10),
(3, 'merchandising','2013-02-02','20','00',50,'pantalon',5,10);

delete from Equipo;
insert into Equipo(id, nombre, categoria, esFilial) values ('1','nombre','categoria', false);
