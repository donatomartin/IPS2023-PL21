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
insert into reserva(nombreusuario,cuentabancaria,precioreserva,fechareserva,horaentrada,horasalida,minutoentrada,minutosalida,fechaventa,horaventa,minutoventa) values
	('aaa','1234567-k',50,'2023-10-20',14,16,30,0,'2023-10-14',14,24),
	('bbb','1234567-k',50,'2023-10-23',14,16,30,0,'2023-10-14',14,24);
	
delete from horarioequipo;
insert into horarioequipo(idequipo,fecha,horaentrada,horasalida,minutoentrada,minutosalida) values
	('eq1', '2023-10-20', 10, 12, 0, 30),
	('eq2', '2023-10-20', 18, 19, 15, 30);
	