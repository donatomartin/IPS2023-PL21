--Datos para carga inicial de la base de datos

--Para giis.demo.tkrun:
	
delete from empleadonodeportivo;
insert into empleadonodeportivo(nombre,apellido,dni,fechaNacimiento,salarioAnual,telefono) values
	('aaa','zzz','12345678K','1985-02-04',10000000, '1234567890'),
	('ccc','yyy', '12345678K','1985-02-04',10000000, '1234567890'),
	('bbb','xxx','12345678K','1985-02-04',10000000, '1234567890'),
	('ddd','www', '12345678K','1985-02-04',10000000, '1234567890');
	
delete from empleadodeportivo;
insert into empleadodeportivo(nombre,apellido,dni,fechaNacimiento,salarioAnual,telefono,posicion) values
	('eee','fff','12345678K','1985-02-04',10000000, '1234567890', 'Delantero'),
	('ggg','hhh','12345678K','1985-02-04',10000000, '1234567890', 'Delantero'),
	('iii','jjj','12345678K','1985-02-04',10000000, '1234567890', 'Delantero');

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
	